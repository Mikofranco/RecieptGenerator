package com.mikotech.Reciept.Generator.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Value("${cloud.api.key}")
    private String apiKey;
    @Value("${cloud.api.name}")
    private String cloudName;
    @Value("${cloud.api.secret}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary (){
        return new Cloudinary(ObjectUtils.asMap(
                "api_key", apiKey,
                "api_secret", apiSecret,
                "secure", "true",
                "cloud_name", cloudName

        ));
    }
}
