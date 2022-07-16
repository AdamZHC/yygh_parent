package com.hit.adam.yygh.hosp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hit.adam.yygh.model.hosp.HospitalSet;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//注意这个泛型是需要导入对应的依赖才能找到的

/**
 * java基础的回顾:
 * 抽象类和接口的继承和实现
 * 1. 对类而言，继承父类，实现父接口/ 对接口而言，继承父接口
 * 2. 单继承，多实现
 * 3. 抽象类类似于位于普通类和接口的中间态，可以不用实现所以方法，只实现部分
 */
@Mapper
@Repository
public interface HospitalSetMapper extends BaseMapper<HospitalSet> {
}
