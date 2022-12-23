package com.codeking.boot.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.boot.common.CustomException;
import com.codeking.boot.entity.Category;
import com.codeking.boot.entity.Dish;
import com.codeking.boot.entity.Setmeal;
import com.codeking.boot.mapper.CategoryMapper;
import com.codeking.boot.service.CategoryService;
import com.codeking.boot.service.DishService;
import com.codeking.boot.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : codeking
 * @create : 2022/12/23 19:36
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    @Override
    public void remove(Long id) {
        //添加查询条件，根据分类id进行查询菜品数据
        LambdaQueryWrapper<Dish> dishQueryWrapper = new LambdaQueryWrapper<>();
        // 添加条件
        dishQueryWrapper.eq(Dish::getCategoryId, id);
        int dishCount = dishService.count(dishQueryWrapper);
        //如果已经关联，抛出一个业务异常
        if (dishCount >0) {
            throw new CustomException("存在关联菜品，无法删除！");
        }
        //查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int setmealCount = setmealService.count(setmealLambdaQueryWrapper);
        if (setmealCount>0){
            throw new CustomException("存在关联菜品，无法删除！");
        }
        //正常删除分类
        super.removeById(id);
    }
}
