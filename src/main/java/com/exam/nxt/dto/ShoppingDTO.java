package com.exam.nxt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
@ApiModel("ShoppingDTO收货地址参数")
@Getter
public class ShoppingDTO {
    @ApiModelProperty("收货人")
    private String receivername;
    @ApiModelProperty("收货电话")
    private String receiverphone;
    @ApiModelProperty("省")
    private String receiverprovince;
    @ApiModelProperty("市")
    private String receivercity;
    @ApiModelProperty("区/县")
    private String receiverdistrict;
    @ApiModelProperty("收货地址")
    private String receiveraddress;
}
