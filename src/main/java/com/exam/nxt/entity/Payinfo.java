package com.exam.nxt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@ToString
@Accessors(chain = true)
@ApiModel(value = "Payinfo对象", description = "")
public class Payinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String payid;

    @ApiModelProperty("订单id")
    private String orderid;

    @ApiModelProperty("用户表id")
    private String userid;

    @ApiModelProperty("支付平台:1-支付宝,2-微信")
    private Integer payplatform;

    @ApiModelProperty("支付流水号")
    private String platformnumber;

    @ApiModelProperty("支付状态")
    private String platformstatus;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatetime;


}
