package com.exam.nxt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId("userid")
    @ApiModelProperty("用户表id")
    private String userid;

    @ApiModelProperty("用户名")
    private String username;
    @JsonIgnore
    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickname;

    private String phone;

    @ApiModelProperty("找回密码问题")
    private String question;

    @ApiModelProperty("找回密码答案")
    private String answer;

    @ApiModelProperty("角色0-管理员,1-普通用户,2-农户")
    private Integer role;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatetime;

    public User(String userid, String phone, Integer role, LocalDateTime createtime, LocalDateTime updatetime) {
        this.userid = userid;
        this.phone = phone;
        this.role = role;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }
}
