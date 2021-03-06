package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.model.entity.SysUser;
import com.service.ISysUserService;
import com.valid.result.response.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author YeGuanWei
 * @since 2021-12-29
 */
@RestController
@RequestMapping("/forum/user")
public class UserController {

    @Resource
    private ISysUserService userService;

    @ApiOperation(value = "list", notes = "list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response<List<SysUser>> list() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        List<SysUser> list = userService.list(queryWrapper);
        return Response.success(list);
    }

}