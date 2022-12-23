package com.codeking.boot.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.boot.common.CustomException;
import com.codeking.boot.entity.Dish;
import com.codeking.boot.mapper.DishMapper;
import com.codeking.boot.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : codeking
 * @create : 2022/12/23 20:09
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

}
