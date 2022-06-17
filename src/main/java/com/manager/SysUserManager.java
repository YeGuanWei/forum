package com.manager;

import com.service.ISysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserManager {

    @Resource
    private ISysUserService sysUserService;

}