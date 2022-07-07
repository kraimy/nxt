package com.exam.nxt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.math.BigDecimal;
@ApiModel("OrderItemDTO订单详情参数")
@Getter
@SuppressWarnings("all")
public class OrderItemDTO {
    @ApiModelProperty("商品id")
    private String proId;
    @ApiModelProperty("商品名称")
    private String proname;
    @ApiModelProperty("商品图片地址")
    private String proimage;
    @ApiModelProperty("商品单价")
    private BigDecimal currentunitprice;
    @ApiModelProperty("商品数量")
    private int quantity;
    @ApiModelProperty("商品总价")
    private BigDecimal totalprice;
}
