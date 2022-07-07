package com.exam.nxt.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口统一返回包装类
 */
@ApiModel("Result接口统一返回包装")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @ApiModelProperty("响应码")
    private String code;
    @ApiModelProperty("响应信息")
    private String msg;
    @ApiModelProperty("响应数据")
    private Object data;

    public static Result success() {
        return new Result(Constants.CODE_200, "", null);
    }

    public static Result success(Object data) {
        return new Result(Constants.CODE_200, "", data);
    }

    public static Result error(String code, String msg) {
        return new Result(code, msg, null);
    }

    public static Result error() {
        return new Result(Constants.CODE_500, "系统错误", null);
    }

}

