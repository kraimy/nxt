package com.exam.nxt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.List;

@ApiModel("AddOrderDTO参数")
@Getter
public class AddOrderDTO {
    @ApiModelProperty("订单中的商品")
    private List<OrderItemDTO> itemDTOS;
    @ApiModelProperty("收获地址")
    private ShoppingDTO shoppingDTO;
    @ApiModelProperty("订单")
    private OrderDTO orderDTO;
}
