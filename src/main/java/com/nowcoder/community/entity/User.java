package com.nowcoder.community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @description：
 * @author： wuying23
 * @create： 2023/11/5 21:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("User")
public class User {
    private String username;
    private int id;
    private String passward;
    private String salt;
    private String email;
    private int type;
    private int status;
    private String activationCode;
    private String headerUrl;
    private Date createTime;
}
