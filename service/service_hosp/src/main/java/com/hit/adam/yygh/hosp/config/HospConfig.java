package com.hit.adam.yygh.hosp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//这里的包扫描不能写错了
@MapperScan("com.hit.adam.yygh.hosp.mapper")
public class HospConfig {

}
