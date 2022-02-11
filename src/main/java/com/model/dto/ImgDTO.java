package com.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author YeGuanWei
 * @since 2022-02-10
 */
@Data
public class ImgDTO {

    @ApiModelProperty(value = "图片名称")
    private String name;

    @ApiModelProperty(value = "文字内容")
    private String content;

    @ApiModelProperty(value = "插入图片地址")
    private String imgPath;

    @ApiModelProperty(value = "x轴")
    private Integer x;

    @ApiModelProperty(value = "y轴")
    private Integer y;

    @ApiModelProperty(value = "字体颜色_r")
    private Integer rgb_r;

    @ApiModelProperty(value = "字体颜色_g")
    private Integer rgb_g;

    @ApiModelProperty(value = "字体颜色_b")
    private Integer rgb_b;


}
