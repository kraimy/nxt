package com.exam.nxt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
@ApiModel("OrderDTO订单参数")
@Getter
public class OrderDTO {
    @ApiModelProperty("实际付款金额,单位是元,保留两位小数")
    private BigDecimal payment;
    @ApiModelProperty("运费,单位是元,非必须参数")
    private BigDecimal postage;
}
