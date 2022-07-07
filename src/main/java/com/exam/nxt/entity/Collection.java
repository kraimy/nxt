package com.exam.nxt.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@ApiModel(value = "Collection对象", description = "")
public class Collection implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("收藏主键")
    @TableId
    private String  collectionId;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("商品id")
    private String proId;

    @ApiModelProperty("0-取消收藏，1-收藏")
    private Integer state;


}
