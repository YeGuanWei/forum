package com.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 法定日期
 * </p>
 *
 * @author YeGuanWei
 * @since 2022-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_holidays")
@ApiModel(value="SysHolidays对象", description="法定日期")
public class SysHolidays implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private String id;

    @ApiModelProperty(value = "所属年份")
    private Integer years;

    @ApiModelProperty(value = "类型 1.节假日  2.调休日")
    private Integer type;

    @ApiModelProperty(value = "时间")
    private LocalDate agreedDate;


    public static final String ID = "id";

    public static final String YEARS = "years";

    public static final String TYPE = "type";

    public static final String AGREED_DATE = "agreed_date";

}