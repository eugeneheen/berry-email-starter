package com.github.eugeneheen.berry.email.starter.pojo.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 邮件属性配置信息
 * @author Eugene
 * 2019-01-19 9:50
 */
@Data
@Component
@ConfigurationProperties(prefix = "email")
@PropertySource(value = "classpath:config/email.properties", encoding = "utf-8")
public class EmailProps {
    /**
     * 邮件SMTP发送地址
     */
    private String smtpAddr;
    /**
     * 邮件SMTP发送端口
     */
    private int smtpPort;
    /**
     * 邮件账户
     */
    private String userName;
    /**
     * 邮件账户密码
     */
    private String password;
    /**
     * 是否开启SSL
     */
    private boolean isSSL;
    /**
     * 邮件发送方地址
     */
    private String addresser;
}
