package com.hit.adam.yygh.hosp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.hit.adam.yygh.result.Result;
import com.hit.adam.yygh.hosp.service.HospitalSetService;
import com.hit.adam.yygh.model.hosp.HospitalSet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("All")
//RestController默认就是ResponseBody返回json
@Api(tags = "医院设置管理")
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {

    @Autowired
    private HospitalSetService hospitalSetService;

    @ApiOperation(value = "获取所有医院设置信息")
    @GetMapping("findAll")
    public Result findAll() {
        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        List<HospitalSet> list = hospitalSetService.list(queryWrapper);
        return Result.ok(list);
    }

    @ApiOperation(value = "逻辑删除医院设置信息")
    @DeleteMapping("{id}")
    public Result delete(@PathVariable Long id) {
        boolean b = hospitalSetService.removeById(id);
        if(b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
