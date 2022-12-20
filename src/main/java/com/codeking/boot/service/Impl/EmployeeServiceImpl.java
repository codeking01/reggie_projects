package com.codeking.boot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.boot.entity.Employee;
import com.codeking.boot.mapper.EmployeeMapper;
import com.codeking.boot.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author : codeking
 * @create : 2022/12/20 20:44
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements  EmployeeService {
}
