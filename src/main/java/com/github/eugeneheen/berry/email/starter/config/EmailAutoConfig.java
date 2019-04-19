package com.github.eugeneheen.berry.email.starter.config;

import com.github.eugeneheen.berry.email.starter.pojo.props.EmailProps;
import com.github.eugeneheen.berry.email.starter.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 邮件服务自动初始化配置类
 *
 * @author Eugene
 * 2019-04-19 10:15
 */
@Configuration
@EnableConfigurationProperties(value = EmailProps.class)
@ConditionalOnClass(EmailService.class)
public class EmailAutoConfig {

    @Autowired
    private EmailProps emailProps;

    @Bean
    @ConditionalOnMissingBean(EmailService.class)
    public EmailService emailService() {
        EmailService emailService = new EmailService();
        emailService.setEmailProps(this.emailProps);
        return emailService;
    }
}
