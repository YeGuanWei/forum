package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.model.entity.SysHolidays;
import com.service.ISysHolidaysService;
import com.valid.result.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/forum/holiday")
public class HolidayController {

    @Resource
    private ISysHolidaysService holidaysService;

    @ApiOperation(value = "demo", notes = "demo")
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public Response<List<SysHolidays>> demo() {
        QueryWrapper<SysHolidays> queryWrapper = new QueryWrapper<>();
        List<SysHolidays> list = holidaysService.list(queryWrapper);
        return Response.success(list);
    }

}