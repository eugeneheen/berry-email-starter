package com.github.eugeneheen.berry.email.starter.service.standard;

import org.apache.commons.mail.EmailException;

/**
 * 邮件业务接口定义
 *
 * @author Eugene
 * 2019-04-19 10:07
 */
public interface IEmailService {


    String sendBySmtp(String addressees, String title, String content) throws EmailException;

    String sendBySmtp(String title, String content, String... addressees) throws EmailException;
}
