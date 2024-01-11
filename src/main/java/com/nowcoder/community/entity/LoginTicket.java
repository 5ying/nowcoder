package com.nowcoder.community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description：
 * @author： wuying23
 * @create： 2024/1/11 23:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginTicket {

    private int id;
    private int userId;
    private String ticket;
    private int status;
    private Date expired;
}
