package com.hit.adam.yygh.hosp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hit.adam.yygh.hosp.mapper.HospitalSetMapper;
import com.hit.adam.yygh.hosp.service.HospitalSetService;
import com.hit.adam.yygh.model.hosp.HospitalSet;
import org.springframework.stereotype.Service;

//注意是在实现类上面加注解
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {
}
