package com.powernow.usm.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class AwsProperties {

    /**
     * aws key
     */
    @Value("${aws.accessKey}")
    private String accessKey;

    /**
     * aws私钥
     */
    @Value("${aws.secertKey}")
    private String secertKey;


    /**
     * aws bucket名字
     */
    @Value("${aws.bucketName}")
    private String bucketName;

}
