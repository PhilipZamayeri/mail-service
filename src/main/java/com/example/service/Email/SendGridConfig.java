package com.example.service.Email;

import com.sendgrid.SendGrid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@Configuration
public class SendGridConfig {
    @Value("${spring.sendgrid.api-key}")
    private String sendGridAPIKey;


    @Bean
    public SendGrid sendGrid(){
        log.info("Api-key {}", sendGridAPIKey);
        return new SendGrid(sendGridAPIKey);
    }

    @Bean
    public EmailService emailService(SendGrid sendGrid){
        return new EmailService(sendGrid);
    }
}
