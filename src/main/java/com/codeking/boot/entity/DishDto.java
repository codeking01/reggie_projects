package com.codeking.boot.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : codeking
 * @create : 2022/12/24 21:44
 */

// 需要继承 Dish,从而达到扩展的效果
@Data
public class DishDto extends  Dish{
    private List<DishFlavor> flavors=new ArrayList<>();
    private String categoryName; //菜品分类名称
    private Integer copies;
}
