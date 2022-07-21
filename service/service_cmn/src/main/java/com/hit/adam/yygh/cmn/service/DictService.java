package com.hit.adam.yygh.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hit.adam.yygh.model.cmn.Dict;

import java.util.List;

public interface DictService extends IService<Dict> {
    List<Dict> findKidsById(Long id);
}
