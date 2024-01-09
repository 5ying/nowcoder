package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @description：
 * @author： wuying23
 * @create： 2024/1/8 23:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTest {
    @Autowired
    private MailClient mailClient;
    @Autowired
    private TemplateEngine templateEngine;
//    测试 邮件发送
    @Test
    public void testTextMail(){
        mailClient.sendMail("1311025321@qq.com","baobao","love you");
    }
//    使用模板引擎发送html页面
    @Test
    public void testHtmlMail(){
        Context context = new Context();
        context.setVariable("username","sunday");
        String content = templateEngine.process("/mail/demo",context);
        System.out.println(content);
        mailClient.sendMail("1311025321@qq.com", "HTML",content);
    }
}
