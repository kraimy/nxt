package com.exam.nxt.service.impl;

import com.exam.nxt.entity.Comments;
import com.exam.nxt.mapper.CommentsMapper;
import com.exam.nxt.service.ICommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kremi
 * @since 2022-07-04
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {

}
