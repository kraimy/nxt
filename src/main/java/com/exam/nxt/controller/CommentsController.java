package com.exam.nxt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.nxt.common.GenerateId;
import com.exam.nxt.common.Result;
import com.exam.nxt.dto.CommentDTO;
import com.exam.nxt.entity.Comments;
import com.exam.nxt.service.impl.CommentsServiceImpl;
import com.exam.nxt.utils.NXTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author kremi
 * @since 2022-07-04
 */
@Api(tags = "评论接口")
@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Resource
    CommentsServiceImpl service;

    @ApiOperation("查询用户评论")
    @GetMapping("/user")
    public Result userComments(HttpServletRequest request) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id", NXTUtils.getuid(request));
        return Result.success(service.list(wrapper));
    }

    @ApiOperation("用户添加或修改评论")
    @PostMapping("/user")
    @CachePut
    public Result addOne(HttpServletRequest request, @RequestBody CommentDTO commentDTO) {
        Comments comment = new Comments();
        BeanUtils.copyProperties(commentDTO, comment);
        if (commentDTO.getCommentId().trim().equals("") || commentDTO.getCommentId() == null) {
            comment.setCommentId(GenerateId.commentId());
        }
        comment.setCommentId(GenerateId.commentId())
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now());
        return Result.success(service.saveOrUpdate(comment));
    }

    @ApiOperation("用户删除评论")
    @DeleteMapping("/user/{commentId}")
    @CacheEvict
    public Result del(HttpServletRequest request, @PathVariable String commentId) {
        Comments comment = service.getById(commentId);
        if (comment.getUseId().equals(NXTUtils.getuid(request)))
            return Result.success(service.removeById(commentId));
        else return Result.error("401", "权限不足");
    }
}
