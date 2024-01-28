package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description：
 * @author： wuying23
 * @create： 2024/1/17 23:28
 */
@Mapper
public interface CommentMapper {

    List<Comment> selectCommentsByEntity(int entityType, int entityId, int offset, int limit);

    int selectCountByEntity(int entityType, int entityId);

    /**
     * 新增评论的方法
     * @param comment
     * @return
     */
    int insertComment(Comment comment);

    Comment selectCommentById(int id);
}
