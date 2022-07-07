package com.exam.nxt.dto;


import java.io.Serializable;
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
 * @since 2022-07-03
 */
@Getter
@Setter
@ApiModel(value = "AddressDTO对象", description = "")
public class AddressDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("收货姓名")
    private String receivername;

    @ApiModelProperty("收货电话")
    private String receiverphone;

    @ApiModelProperty("省份")
    private String receiverprovince;

    @ApiModelProperty("城市")
    private String receivercity;

    @ApiModelProperty("区/县")
    private String receiverdistrict;

    @ApiModelProperty("详细地址")
    private String receiveraddress;

    @ApiModelProperty("1为默认地址,0为正常状态")
    private Integer def;


}

