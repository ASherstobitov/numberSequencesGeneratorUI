package com.aleksei.numbersequnces.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Getter
@Configuration
@ComponentScan("com.aleksei.numbersequnces")
@PropertySource({"classpath:application.properties"})
public class AppConfig {

    @Value("${server.generator.url}")
    public String generatorUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
