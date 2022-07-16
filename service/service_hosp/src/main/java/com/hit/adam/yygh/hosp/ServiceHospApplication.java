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
//swagger2类似是一个工具的实现，并不需要真的在对应的工具类里面启动对应的服务
//我就说吧！！！只是在对应的项目启动的端口上多开了一个地址
//没有启动一个新的服务，所以说不能算是微服务的思想

/**
 * 多出来的那几个部分估计是弄错了！！！
 */
@ComponentScan(basePackages = "com.hit.adam")
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class);
    }
}
