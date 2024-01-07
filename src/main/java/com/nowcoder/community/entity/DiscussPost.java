package com.nowcoder.community.entity;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @description：
 * @author： wuying23
 * @create： 2023/11/10 00:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Alias("DiscussPost")
public class DiscussPost {
    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private int type;
    private int status;
    private Date createTime;
    private int commentCount;
    private double score;
}
