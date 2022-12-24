package com.codeking.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codeking.boot.entity.Dish;
import com.codeking.boot.entity.DishDto;

/**
 * @author : codeking
 * @create : 2022/12/23 20:09
 */
public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish、dish_flavor
    void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavor(Long id);

    // 根据内容修改菜品
    void updateByIdWithFlavor(DishDto dishDto);
}
