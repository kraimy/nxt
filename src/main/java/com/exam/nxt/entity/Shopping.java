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
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "Shopping对象", description = "")
public class Shopping implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private String shoppingid;

    @ApiModelProperty("用户表id")
    private String userid;

    @ApiModelProperty("订单id")
    private String orderid;

    @ApiModelProperty("收货姓名")
    private String receivername;

    @ApiModelProperty("收货固定电话")
    private String receiverphone;

    @ApiModelProperty("收货移动电话")
    private String receivermobile;

    @ApiModelProperty("省份")
    private String receiverprovince;

    @ApiModelProperty("城市")
    private String receivercity;

    @ApiModelProperty("区/县")
    private String receiverdistrict;

    @ApiModelProperty("详细地址")
    private String receiveraddress;

    private LocalDateTime createtime;

    private LocalDateTime updatetime;


}
