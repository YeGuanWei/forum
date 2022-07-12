package com.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.model.entity.CloudOrg;

/**
 * <p>
 * 组织机构表 服务类
 * </p>
 *
 * @author YeGuanWei
 * @since 2021-11-05
 */
@DS("slave_1")
public interface ICloudOrgService extends IService<CloudOrg> {

}