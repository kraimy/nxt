package com.exam.nxt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
@ApiModel(value = "Comments对象", description = "")
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    private String commentId;

    private String useId;

    private String proId;

    private String comment;

    @ApiModelProperty("评论状态0-yi，1-n未删除")
    private Integer state;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
