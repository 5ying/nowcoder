package com.nowcoder.community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @description：
 * @author： wuying23
 * @create： 2024/1/28 21:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Message")
public class Message {

    private int id;
    private int fromId;
    private int toId;
    private String conversationId;
    private String content;
    private int status;
    private Date createTime;
}
