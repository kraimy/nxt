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
@ApiModel(value = "Orderitem对象", description = "")
public class Orderitem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单子表id")
    @TableId
    private String id;

    @ApiModelProperty("订单id")
    private String orderid;

    @ApiModelProperty("用户表id")
    private String userid;

    @ApiModelProperty("商品id")
    private String proid;

    @ApiModelProperty("商品名称")
    private String proname;

    @ApiModelProperty("商品图片地址")
    private String proimage;

    @ApiModelProperty("生成订单时的商品单价，单位是元,保留两位小数")
    private BigDecimal currentunitprice;

    @ApiModelProperty("商品数量")
    private Integer quantity;

    @ApiModelProperty("商品总价,单位是元,保留两位小数")
    private BigDecimal totalprice;

    private LocalDateTime createtime;

    private LocalDateTime updatetime;


}
