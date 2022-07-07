package com.exam.nxt.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author kremi
 * @since 2022-07-04
 */
@Getter
@Setter
@ApiModel(value = "Comments对象", description = "")
public class CommentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String commentId;

    private String proId;

    private String comment;



}