package com.emmett.bookclub.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Configuration
@PropertySource("classpath:/open-api.properties")
public class RestTemplateConfig {
    @Value("${rest.ignore.ssl}")
    private Boolean ignoreSsl;

    @Bean
    public RestTemplate restTemplate() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        if (ignoreSsl) {
            //SSL ignore
            return new RestTemplate(HttpClientConfig.httpRequestFactory());
        } else {
            return new RestTemplate();
        }
    }
}
