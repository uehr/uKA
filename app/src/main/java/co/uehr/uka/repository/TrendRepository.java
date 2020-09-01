package co.uehr.uka.repository;

import co.uehr.uka.entity.TrendEntity;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface TrendRepository extends JpaRepository<TrendEntity, Long> {
    @Modifying
    @Transactional
    public void deleteByTrendingAtBefore(Date date);
}