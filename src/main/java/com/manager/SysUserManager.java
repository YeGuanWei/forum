package com.manager;

import com.model.entity.SysUser;
import com.service.ISysUserService;
import com.valid.result.code.IErrorCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserManager {

    @Resource
    private ISysUserService sysUserService;


    /*public IErrorCode create(){

    }*/

}
