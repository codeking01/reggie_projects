package com.codeking.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeking.boot.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : codeking
 * @create : 2022/12/23 20:08
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
