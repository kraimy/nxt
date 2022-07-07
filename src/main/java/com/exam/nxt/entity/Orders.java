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
@ApiModel(value = "Orders对象", description = "")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id")
    @TableId
    private String orderid;

    @ApiModelProperty("用户id")
    private String userid;

    private String shoppingid;

    @ApiModelProperty("实际付款金额,单位是元,保留两位小数")
    private BigDecimal payment;

    @ApiModelProperty("支付类型,1-在线支付")
    private Integer paymenttype;

    @ApiModelProperty("运费,单位是元")
    private BigDecimal postage;

    @ApiModelProperty("订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭")
    private Integer status;

    @ApiModelProperty("支付时间")
    private LocalDateTime paymenttime;

    @ApiModelProperty("发货时间")
    private LocalDateTime sendtime;

    @ApiModelProperty("交易完成时间")
    private LocalDateTime endtime;

    @ApiModelProperty("交易关闭时间")
    private LocalDateTime closetime;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatetime;


}
