package com.nowcoder.community.contorller;

import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.UserService;
import com.nowcoder.community.util.CommunityConstant;
import com.nowcoder.community.util.CommunityUtil;
import com.nowcoder.community.util.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.TemplateEngine;

import java.util.Map;

/**
 * @description：
 * @author： wuying23
 * @create： 2023/11/6 23:20
 */
@Controller
public class LoginController implements CommunityConstant {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String getRegisterPage() {
        return "site/register";
    }
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(Model model, User user) {
        Map<String, Object> map = userService.register(user);
        if (map == null || map.isEmpty()) {
            model.addAttribute("msg", "注册成功,已经向您的邮箱发送邮件，请进行激活！");
            model.addAttribute("target", "/index");
            return "/site/operate-result";
        } else {
            model.addAttribute("usernameMsg", map.get("usernameMsg"));
            model.addAttribute("passwordMsg", map.get("passwordMsg"));
            model.addAttribute("emailMsg", map.get("emailMsg"));
            return "/site/register";
        }
    }
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "site/login";
    }


    // http://localhost:8080/community/activation/101/code
    @RequestMapping(path = "/activation/{userId}/{code}", method = RequestMethod.GET)
    public String activation(Model model, @PathVariable("userId") int userId, @PathVariable("code") String code) {
        int result = userService.activation(userId, code);
        if (result == ACTIVATION_SUCCESS) {
            model.addAttribute("msg", "激活成功,您的账号已经可以正常使用了!");
            model.addAttribute("target", "/login");
        } else if (result == ACTIVATION_REPEAT) {
            model.addAttribute("msg", "无效操作,该账号已经激活过了!");
            model.addAttribute("target", "/index");
        } else {
            model.addAttribute("msg", "激活失败,您提供的激活码不正确!");
            model.addAttribute("target", "/index");
        }
        return "/site/operate-result";
    }

//    @RequestMapping(path = "/login", method = RequestMethod.POST)
//    public String login(String username, String password, String code, boolean rememberme,
//                        Model model, HttpServletResponse response) {
//        // 检查验证码
//        // String kaptcha = (String) session.getAttribute("kaptcha");
//        String kaptcha = null;
//        if (StringUtils.isNotBlank(kaptchaOwner)) {
//            String redisKey = RedisKeyUtil.getKaptchaKey(kaptchaOwner);
//            kaptcha = (String) redisTemplate.opsForValue().get(redisKey);
//        }
//
//        if (StringUtils.isBlank(kaptcha) || StringUtils.isBlank(code) || !kaptcha.equalsIgnoreCase(code)) {
//            model.addAttribute("codeMsg", "验证码不正确!");
//            return "/site/login";
//        }
//
//        // 检查账号,密码
//        int expiredSeconds = rememberme ? REMEMBER_EXPIRED_SECONDS : DEFAULT_EXPIRED_SECONDS;
//        Map<String, Object> map = userService.login(username, password, expiredSeconds);
//        if (map.containsKey("ticket")) {
//            Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
//            cookie.setPath(contextPath);
//            cookie.setMaxAge(expiredSeconds);
//            response.addCookie(cookie);
//            return "redirect:/index";
//        } else {
//            model.addAttribute("usernameMsg", map.get("usernameMsg"));
//            model.addAttribute("passwordMsg", map.get("passwordMsg"));
//            return "/site/login";
//        }
//    }
}
