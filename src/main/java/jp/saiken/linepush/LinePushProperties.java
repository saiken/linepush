package jp.saiken.linepush;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "line.bot")
public class LinePushProperties {
    private String channelSecret;
    private String channelToken;
    private String target;
}
