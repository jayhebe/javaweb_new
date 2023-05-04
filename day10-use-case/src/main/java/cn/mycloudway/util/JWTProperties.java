package cn.mycloudway.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jwt.configuration")
public class JWTProperties {
    private String signKey;
    private Long expire;
}
