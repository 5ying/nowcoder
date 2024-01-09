package com.nowcoder.community.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @description：
 * @author： wuying23
 * @create： 2024/1/8 23:23
 */
@Component
public class MailClient {
//    日后补充log 日志接入
    @Resource
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;

    public void sendMail(String to, String subject, String contents){
        try {
            MimeMessage  message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(contents, true);
            mailSender.send(messageHelper.getMimeMessage());
        } catch (MessagingException e) {
//            新加日志打印
            throw new RuntimeException(e);
        }

    }
}
