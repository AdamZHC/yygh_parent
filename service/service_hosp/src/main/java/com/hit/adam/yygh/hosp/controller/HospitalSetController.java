package com.hit.adam.yygh.hosp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hit.adam.yygh.hosp.service.HospitalSetService;
import com.hit.adam.yygh.model.hosp.HospitalSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("All")
//RestController默认就是ResponseBody返回json
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {

    @Autowired
    private HospitalSetService hospitalSetService;

    @GetMapping("findAll")
    public List<HospitalSet> findAll() {
        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        List<HospitalSet> list = hospitalSetService.list(queryWrapper);
        return list;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id) {
        boolean b = hospitalSetService.removeById(id);
        return b;
    }

}
