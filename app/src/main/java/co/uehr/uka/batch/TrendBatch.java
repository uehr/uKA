package co.uehr.uka.batch;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.social.twitter.api.Trend;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

import co.uehr.uka.entity.TrendEntity;
import co.uehr.uka.repository.TrendRepository;

@Component
public class TrendBatch {
    protected static final Logger log = LoggerFactory.getLogger(TrendBatch.class);

    @Autowired
    Twitter twitterApi;

    @Autowired
    TrendRepository trendRepository;

    // トレンドの対象地域を取得
    @Value("${uka.trend-woeid}")
    private int trendWOEID;

    // トレンドデータの保持期間
    @Value("${uka.trend-retention-hours}")
    private int trendRetentionHours;

    // Twitterトレンド同期
    @Scheduled(cron = "${uka.fetch-new-trends-cron}")
    public void fetchNewTrends() {
        List<Trend> trends = twitterApi.searchOperations().getLocalTrends(trendWOEID).getTrends();
        Date now = new Date();
        for (int i = 0; i < trends.size(); i++) {
            TrendEntity fetchedTrend = TrendEntity.builder()
                .word(trends.get(i).getName())
                .rank(i)
                .trendingAt(now)
                .build();
            trendRepository.save(fetchedTrend);
        }
        log.info("Fetched new twitter trends");
    }

    // 古いトレンドデータを削除
    @Scheduled(cron = "${uka.delete-old-trends-cron}")
    public void deleteOldTrends() {
        // トレンドデータの保持期間を過ぎた古いデータを削除
        Date thresholdDate = new Date(System.currentTimeMillis() - trendRetentionHours * 3600 * 1000);
        trendRepository.deleteByTrendingAtBefore(thresholdDate);
        log.info("Deleted old trend rows");
    }
}