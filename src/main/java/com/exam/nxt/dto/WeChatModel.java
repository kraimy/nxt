package com.exam.nxt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@ApiModel("WeChat小程序一键登录或注册请求参数")
@Getter
@Data
public class WeChatModel {
    @ApiModelProperty("请求码")
    private String code;
    @ApiModelProperty("头像")
    private String avatarUrl;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("openid")
    private String openId;
    @ApiModelProperty("电话")
    @Digits(integer = 11, fraction = 0, message = "十一位电话号")
    @NotBlank
    private String phone;
}
