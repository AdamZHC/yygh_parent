package com.hit.adam.yygh.cmn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hit.adam.yygh.cmn.mapper.DictMapper;
import com.hit.adam.yygh.cmn.service.DictService;
import com.hit.adam.yygh.model.cmn.Dict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Override
    public List<Dict> findKidsById(Long id) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", id);
        List<Dict> kidsList = baseMapper.selectList(queryWrapper);
        //遍历赋值
        for(Dict dict : kidsList)
            if(hasKids(dict.getId()))
                dict.setHasChildren(true);

        return kidsList;
    }

    public boolean hasKids(Long id) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", id);
        Integer val = baseMapper.selectCount(queryWrapper);
        return val > 0;
    }
}
