package com.codeking.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeking.boot.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : codeking
 * @create : 2022/12/20 20:41
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
