package cn.mycloudway;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class AliOSSUtils {
    private AliOSSProperties aliOSSProperties;

    public AliOSSProperties getAliOSSProperties() {
        return aliOSSProperties;
    }

    public void setAliOSSProperties(AliOSSProperties aliOSSProperties) {
        this.aliOSSProperties = aliOSSProperties;
    }

    public String upload(MultipartFile file) throws IOException {
        String endpoint = aliOSSProperties.getEndpoint();
        String accessKey = aliOSSProperties.getAccessKey();
        String accessSecret = aliOSSProperties.getAccessSecret();
        String bucketName = aliOSSProperties.getBucketName();

        InputStream inputStream = file.getInputStream();

        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKey, accessSecret);
        ossClient.putObject(bucketName, fileName, inputStream);

        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;

        ossClient.shutdown();

        return url;
    }
}
