package com.hit.adam.yygh.hosp.controller;


import com.alibaba.excel.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hit.adam.yygh.result.Result;
import com.hit.adam.yygh.hosp.service.HospitalSetService;
import com.hit.adam.yygh.model.hosp.HospitalSet;
import com.hit.adam.yygh.utils.MD5;
import com.hit.adam.yygh.vo.hosp.HospitalQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

@SuppressWarnings("All")
//RestController默认就是ResponseBody返回json
@Api(tags = "医院设置管理")
@RestController
@CrossOrigin
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
    @DeleteMapping("deleteById/{id}")
    public Result delete(@PathVariable Long id) {
        boolean b = hospitalSetService.removeById(id);
        if(b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 本来在最一开始的时候就是请求路径拼接请求参数的，现在就是restful风格
     * 再使用查询加上分页restful 查询参数拼接
     * 使用restful在路径上就变成了required
     *
     * 用json的时候，此时就是可写可不写
     */
    @ApiOperation("分页查询医院")
    @PostMapping("findPage/{current}/{limit}")
    public Result queryPageHospitalSet(@PathVariable("current") Long current,
                                       @PathVariable("limit") Long limit,
                                       @RequestBody(required = false) HospitalQueryVo hospitalQueryVo) {
        Page<HospitalSet> page = new Page(current, limit);
        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        if(hospitalQueryVo != null) {
            //医院编号精确查询
            String hoscode = hospitalQueryVo.getHoscode();
            if(!StringUtils.isEmpty(hoscode))
                queryWrapper.eq("hoscode", hoscode);
            //医院名称模糊查询
            String hosname = hospitalQueryVo.getHosname();
            if(!StringUtils.isEmpty(hosname))
                queryWrapper.like("hosname", hosname);
            //医院类型精确查询
            String hostype = hospitalQueryVo.getHostype();
            if(!StringUtils.isEmpty(hostype))
                queryWrapper.eq("hostype", hostype);
            //省编号精确查询
            String provinceCode = hospitalQueryVo.getProvinceCode();
            if(!StringUtils.isEmpty(provinceCode))
                queryWrapper.eq("provinceCode", provinceCode);
            //市编号精确查询
            String cityCode = hospitalQueryVo.getCityCode();
            if(!StringUtils.isEmpty(cityCode))
                queryWrapper.eq("cityCode", cityCode);
            //区域编号精确查询
            String districtCode = hospitalQueryVo.getDistrictCode();
            if(!StringUtils.isEmpty(hoscode))
                queryWrapper.eq("hoscode", hoscode);
            //状态查询
            Integer status = hospitalQueryVo.getStatus();
            if(status != null)
                queryWrapper.eq("status", status);
        }
        Page<HospitalSet> list = hospitalSetService.page(page, queryWrapper);
        return Result.ok(list);
    }

    @ApiOperation("添加医院设置")
    @PostMapping("addHospitalSet")
    public Result addHospitalSet(@RequestBody HospitalSet hospitalSet) {
        hospitalSet.setStatus(1);
        Random r = new Random();
        String signKey = MD5.encrypt("" + System.currentTimeMillis() + r.nextInt(1000));
        hospitalSet.setSignKey(signKey);
        boolean save = hospitalSetService.save(hospitalSet);
        if(save)
            return Result.ok();
        else
            return Result.fail();
    }
    //根据Id查询
    @ApiOperation("根据Id查询")
    @GetMapping("queryById/{id}")
    public Result queryById(@PathVariable Long id) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        return Result.ok(hospitalSet);
    }
    //修改对应数据只能通过id其它的不太合适
    @ApiOperation("修改对应数据")
    @PostMapping("updateById/{id}")
    public Result updateById(@PathVariable Long id, @RequestBody HospitalSet hospitalSet) {
        hospitalSet.setId(id);
        boolean b = hospitalSetService.updateById(hospitalSet);
        if(b)
            return Result.ok();
        else
            return Result.fail();
    }
    //批量删除
    @ApiOperation("批量删除")
    @DeleteMapping("deleteBatch")
    public Result deleteBatch(@RequestBody List<Long> ids) {
        boolean b = hospitalSetService.removeByIds(ids);
        if(b)
            return Result.ok();
        else
            return Result.fail();
    }

    //解锁和锁定
    @ApiOperation("解锁和锁定")
    @PutMapping("lock/{id}/{status}")
    public Result lockById(@PathVariable("id") Long id,
                           @PathVariable("status") Integer status) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        hospitalSet.setStatus(status);
        boolean b = hospitalSetService.updateById(hospitalSet);
        if(b)
            return Result.ok();
        else
            return Result.fail();
    }

    //发送签名
    @ApiOperation("发送签名")
    @GetMapping("sendKey/{id}")
    public Result sendKey(@PathVariable Long id) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        String signKey = hospitalSet.getSignKey();
        //TODO
        return Result.ok(signKey);
    }

}
