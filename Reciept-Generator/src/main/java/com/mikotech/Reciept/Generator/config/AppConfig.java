package com.mikotech.Reciept.Generator.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Value("${email.api.key}")
    private String emailApiKey;
    @Value("${email.api.url}")
    private String emailServiceUrl;

    public String getEmailServiceUrl() {
        return emailServiceUrl;
    }

    public void setEmailServiceUrl(String emailServiceUrl) {
        this.emailServiceUrl = emailServiceUrl;
    }

    public String getEmailApiKey() {
        return emailApiKey;
    }

    public void setEmailApiKey(String emailApiKey) {
        this.emailApiKey = emailApiKey;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
