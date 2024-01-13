package com.nowcoder.community.util;

/**
 * @description：
 * @author： wuying23
 * @create： 2024/1/13 20:20
 */

import org.springframework.stereotype.Component;

import com.nowcoder.community.entity.User;

/**
 * 使用用户信息，用于代替session对象
 */
@Component

public class HostHold {
    private static ThreadLocal<User> users = new ThreadLocal<>();
    public void setUser(User user) {
        users.set(user);
    }
    public User getUser() {
        return users.get();
    }
    public void clear() {
        users.remove();
    }
}
