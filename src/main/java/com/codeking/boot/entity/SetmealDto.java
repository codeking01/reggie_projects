package com.codeking.boot.entity;

import lombok.Data;

import java.util.List;

/**
 * @author : codeking
 * @create : 2022/12/25 23:33
 */
@Data
public class SetmealDto extends Setmeal{
    private List<SetmealDish> setmealDishes;//套餐关联的菜品集合
    private String categoryName;//分类名称
}
