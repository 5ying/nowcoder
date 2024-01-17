package com.nowcoder.community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @description：
 * @author： wuying23
 * @create： 2024/1/17 23:27
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Alias("Comment")
public class Comment {

    private int id;
    private int userId;
    private int entityType;
    private int entityId;
    private int targetId;
    private String content;
    private int status;
    private Date createTime;
}
