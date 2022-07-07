package com.exam.nxt.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-06-28
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Product对象", description = "")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    @TableId
    private String proid;

    @ApiModelProperty("类别Id")
    private String cateid;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品副标题")
    private String subtitle;

    @ApiModelProperty("产品主图,url相对地址")
    private String mainimage;

    @ApiModelProperty("图片地址,json格式,扩展用,产品说明图")
    private String subimages;

    @ApiModelProperty("商品详情")
    private String detail;

    @ApiModelProperty("价格,单位-元保留两位小数")
    private BigDecimal price;

    @ApiModelProperty("库存数量")
    private Integer stock;

    @ApiModelProperty("商品状态.1-在售 2-下架 3-删除")
    private Integer status;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatetime;


}
