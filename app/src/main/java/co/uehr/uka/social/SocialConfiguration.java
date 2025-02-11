package co.uehr.uka.social;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import co.uehr.uka.security.AuthUtil;

import javax.inject.Inject;
import javax.sql.DataSource;

@Configuration
public class SocialConfiguration {
    protected static final Logger log = LoggerFactory.getLogger(SocialConfiguration.class);

    @Value("${spring.social.twitter.appId}")
    private String appId;

    @Value("${spring.social.twitter.appSecret}")
    private String appSecret;

    @Value("${spring.social.twitter.appToken}")
    private String appToken;

    @Value("${spring.social.twitter.appTokenSecret}")
    private String appTokenSecret;

    @Bean
    public SocialConfigurer socialConfigurerAdapter(DataSource dataSource) {
        return new DatabaseSocialConfigurer(dataSource);
    }

    @Bean
    public SignInAdapter authSignInAdapter() {
        return (userId, connection, request) -> {
            AuthUtil.authenticate(connection);
            return null;
        };
    }

    @Bean
    public Twitter twitterApi() {
        return new TwitterTemplate(appId, appSecret, appToken, appTokenSecret);
    }
}