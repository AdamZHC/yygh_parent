package com.hit.adam.yygh.cmn.controller;

import com.hit.adam.yygh.cmn.service.DictService;
import com.hit.adam.yygh.model.cmn.Dict;
import com.hit.adam.yygh.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags =  "数据字典接口")
@SuppressWarnings("All")
@RestController
@RequestMapping("/admin/cmn/dict")
public class DictController {
    @Autowired
    private DictService dictService;

    @ApiOperation("查询子节点接口")
    @GetMapping("findKids/{id}")
    public Result findKidsById(@PathVariable Long id) {
        List<Dict> kids = dictService.findKidsById(id);
        return Result.ok(kids);
    }
}
