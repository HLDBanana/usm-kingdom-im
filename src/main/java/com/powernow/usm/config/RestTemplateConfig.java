package com.powernow.usm.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @create: 2021/2/23 10:04
 * @update: 2021/2/23 10:04
 */
@Configuration
public class RestTemplateConfig {

    @Bean(value="restTemplate")
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        //requestFactory.setConnectTimeout(Constants.HTTP.CONNECT_TIMEOUT); //链接超时
        //requestFactory.setReadTimeout(Constants.HTTP.READ_TIMEOUT); //读取超时
        return new RestTemplate(requestFactory);
    }
}
