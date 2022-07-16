package com.hit.adam.yygh.hosp;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//之前是加入pom的依赖就可以使用注解
//目前已经加了所以说可以这样使用
//引导类
@SpringBootApplication
//因为需要不是在一个项目的Bean管理
//所以需要加上这样一个组件扫描注解来实现注册bean
@ComponentScan(basePackages = "com.hit.adam")
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class);
    }
}
