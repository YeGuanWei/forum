package com.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 组织机构表
 * </p>
 *
 * @author YeGuanWei
 * @since 2021-11-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "CloudOrg对象", description = "组织机构表")
public class CloudOrg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父节点")
    private Integer parentId;

    @ApiModelProperty(value = "编码")
    private String placeCode;

    @ApiModelProperty(value = "行政区划编码")
    private String govCode;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "级别")
    private Integer level;

    @ApiModelProperty(value = "电话开头 如:0517")
    private String areaCodePhone;

    @ApiModelProperty(value = "所属行业ID")
    private Integer industryId;

    @ApiModelProperty(value = "是否是子节点")
    private Integer isSub;

    @ApiModelProperty(value = "是否可被编辑")
    private Integer isEdit;

    @ApiModelProperty(value = "UUID")
    private String uuid;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建人")
    private Integer createUserId;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "最后更新人")
    private Integer updateUserId;

    @ApiModelProperty(value = "最后更新时间")
    private Long updateTime;

    @ApiModelProperty(value = "删除标记")
    private Integer delFlag;


    public static final String ID = "id";

    public static final String PARENT_ID = "parent_id";

    public static final String PLACE_CODE = "place_code";

    public static final String GOV_CODE = "gov_code";

    public static final String NAME = "name";

    public static final String LEVEL = "level";

    public static final String AREA_CODE_PHONE = "area_code_phone";

    public static final String INDUSTRY_ID = "industry_id";

    public static final String IS_SUB = "is_sub";

    public static final String IS_EDIT = "is_edit";

    public static final String UUID = "uuid";

    public static final String REMARK = "remark";

    public static final String CREATE_USER_ID = "create_user_id";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_USER_ID = "update_user_id";

    public static final String UPDATE_TIME = "update_time";

    public static final String DEL_FLAG = "del_flag";

}