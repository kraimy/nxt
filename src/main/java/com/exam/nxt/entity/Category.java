package com.exam.nxt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
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
@ApiModel(value = "Category对象", description = "")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("类别Id")
    @TableId
    private String cateid;

    @ApiModelProperty("父类别id当id=0时说明是根节点,一级类别")
    private String parentid;

    @ApiModelProperty("类别名称")
    private String name;

    @ApiModelProperty("类别状态1-正常,2-已废弃")
    private Integer status;

    @ApiModelProperty("排序编号,同类展示顺序,数值相等则自然排序")
    private Integer sortorder;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatetime;


}
