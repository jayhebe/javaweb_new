package cn.mycloudway.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "alicloud.oss")
public class AliOSSProperties {
    private String endpoint;
    private String accessKey;
    private String accessSecret;
    private String bucketName;
}
