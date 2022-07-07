package com.exam.nxt.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
@ApiModel("ProductDTO上传产品参数")
@Getter
public class ProductDTO {
    @ApiModelProperty("类别Id")
    private String cateid;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品副标题")
    private String subtitle;

    @ApiModelProperty("商品详情")
    private String detail;

    @ApiModelProperty("价格,单位-元保留两位小数")
    private BigDecimal price;

    @ApiModelProperty("库存数量")
    private Integer stock;

    @ApiModelProperty("商品状态.1-在售 2-下架 3-删除")
    private Integer status;

}
