package jp.saiken.linepush;

import com.linecorp.bot.client.ChannelTokenSupplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableOAuth2Client
public class AccessTokenManager {
    private final OAuth2RestOperations oAuth2RestTemplate;

    public AccessTokenManager(
            final OAuth2ProtectedResourceDetails resourceDetails) {
        oAuth2RestTemplate = new OAuth2RestTemplate(resourceDetails, new DefaultOAuth2ClientContext());
    }

    @Bean
    public ChannelTokenSupplier channelTokenSupplier() {
        OAuth2AccessToken accessToken = oAuth2RestTemplate.getAccessToken();
        return accessToken::getValue;
    }
}
