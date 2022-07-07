package com.exam.nxt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ApiModel("PayinfoDTO支付参数")
@Getter
public class PayinfoDTO {
    @ApiModelProperty("支付平台:1-支付宝,2-微信,3--余额,4--好友代付")
    private int payplatform;
    @ApiModelProperty("支付流水号")
    private String platformnumber;
    @ApiModelProperty("支付状态")
    private String platformstatus;
}
