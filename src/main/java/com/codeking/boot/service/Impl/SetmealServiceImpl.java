package com.codeking.boot.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.boot.common.CustomException;
import com.codeking.boot.entity.Setmeal;
import com.codeking.boot.entity.SetmealDish;
import com.codeking.boot.entity.SetmealDto;
import com.codeking.boot.mapper.SetmealMapper;
import com.codeking.boot.service.DishService;
import com.codeking.boot.service.SetmealDishService;
import com.codeking.boot.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : codeking
 * @create : 2022/12/23 20:12
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
    @Autowired
    private SetmealDishService setmealDishService;

    @Override
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
        // 这个地方需要操作两个数据表
        // 先保存基本信息
        this.save(setmealDto);
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((item)->{
            item.setSetmealId(setmealDto.getId());
            return item;
        }).collect(Collectors.toList());
        //保存套餐和菜品的关联信息，操作setmeal_dish,执行insert操作
        setmealDishService.saveBatch(setmealDishes);
    }

    @Override
    public void updateStatus(Setmeal setmeal) {
        super.updateById(setmeal);
    }

    @Override
    @Transactional
    public void removeWithDish(List<Long> ids) {
        //select count(*) from setmeal where id in (1,2,3) and status = 1
        //查询套餐状态，确定是否可用删除
        LambdaQueryWrapper<Setmeal> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 添加查询条件
        // 查看是否存在在售的内容
        lambdaQueryWrapper.eq(Setmeal::getStatus,1);
        int count = this.count(lambdaQueryWrapper);
        if(count>0){
            //如果不能删除，抛出一个业务异常
            throw new CustomException("存在在售商品，无法删除");
        }
        //如果可以删除，先删除套餐表中的数据---setmeal
        this.removeByIds(ids);
        //delete from setmeal_dish where setmeal_id in (1,2,3)
        LambdaQueryWrapper<SetmealDish> setmealDishQuery = new LambdaQueryWrapper<>();
        setmealDishQuery.in(SetmealDish::getId,ids);
        //删除关系表中的数据----setmeal_dish
        setmealDishService.remove(setmealDishQuery);
    }
}
