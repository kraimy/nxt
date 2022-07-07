package com.exam.nxt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author kremi
 * @since 2022-06-28
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Cart对象", description = "jnjn")
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String carid;

    @ApiModelProperty("用户表id")
    private String userid;

    @ApiModelProperty("商品id")
    private String proid;

    @ApiModelProperty("数量")
    private Integer quantity;

    @ApiModelProperty("是否选择,1=已勾选,0=未勾选")
    private Integer checked;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatetime;


}
