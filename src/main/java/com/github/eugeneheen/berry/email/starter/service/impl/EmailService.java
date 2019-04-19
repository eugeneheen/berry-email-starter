package com.github.eugeneheen.berry.email.starter.service.impl;

import com.github.eugeneheen.berry.email.starter.pojo.props.EmailProps;
import com.github.eugeneheen.berry.email.starter.service.standard.IEmailService;
import lombok.Setter;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * 邮件业务实现
 *
 * @author Eugene
 * 2019-04-19 10:04
 */
public class EmailService implements IEmailService {

    @Setter
    private EmailProps emailProps;
    @Override
    public String sendBySmtp(String title, String content, String... addressees) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName(this.emailProps.getSmtpAddr());
        email.setSmtpPort(this.emailProps.getSmtpPort());
        email.setAuthenticator(new DefaultAuthenticator(this.emailProps.getUserName(), this.emailProps.getPassword()));
        email.setSSLOnConnect(this.emailProps.isSSL());
        email.setFrom(this.emailProps.getAddresser());
        email.addTo(addressees);
        email.setSubject(title);
        email.setMsg(content);
        return email.send();
    }
}
