package com.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author YeGuanWei
 * @since 2021-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value="SysUser对象", description="用户表")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private String id;

    @ApiModelProperty(value = "用户登录账号")
    private String userName;

    @ApiModelProperty(value = "用户真实姓名")
    private String realName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "身份证")
    private String idCard;

    @ApiModelProperty(value = "用户头像")
    private String userPic;

    @ApiModelProperty(value = "用户类型")
    private Integer type;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建人")
    private String createUserId;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "最后更新人")
    private String updateUserId;

    @ApiModelProperty(value = "最后更新时间")
    private Long updateTime;

    @ApiModelProperty(value = "删除标记")
    private Integer delFlag;


    public static final String ID = "id";

    public static final String USER_NAME = "user_name";

    public static final String REAL_NAME = "real_name";

    public static final String PASSWORD = "password";

    public static final String ID_CARD = "id_card";

    public static final String USER_PIC = "user_pic";

    public static final String TYPE = "type";

    public static final String SEX = "sex";

    public static final String PHONE = "phone";

    public static final String STATUS = "status";

    public static final String CREATE_USER_ID = "create_user_id";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_USER_ID = "update_user_id";

    public static final String UPDATE_TIME = "update_time";

    public static final String DEL_FLAG = "del_flag";

}
