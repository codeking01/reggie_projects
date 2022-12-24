package com.codeking.boot.controller;

/**
 * @author : codeking
 * @create : 2022/12/24 21:37
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codeking.boot.common.R;
import com.codeking.boot.entity.Category;
import com.codeking.boot.entity.Dish;
import com.codeking.boot.entity.DishDto;
import com.codeking.boot.service.CategoryService;
import com.codeking.boot.service.DishFlavorService;
import com.codeking.boot.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜品管理
 */
@RestController
@RequestMapping("/dish")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private DishFlavorService dishFlavorService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增菜品
     *
     * @param dishDto
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto) {
        log.info(dishDto.toString());
        dishService.saveWithFlavor(dishDto);
        return R.success("添加新菜品成功！");
    }


    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        //构造分页构造器对象
        Page<Dish> pageInfo = new Page<>(page, pageSize);

        Page<DishDto> dishDtoInfo = new Page<>(page, pageSize);
        //条件构造器
        LambdaQueryWrapper<Dish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        lambdaQueryWrapper.like(name != null, Dish::getName, name);
        //添加排序条件
        lambdaQueryWrapper.orderByDesc(Dish::getUpdateTime);
        //执行分页查询
        dishService.page(pageInfo, lambdaQueryWrapper);

        // 整体思路：先用dish的这个表查出部分内容，然后复制过去，在进行扩展字段的内容
        //对象拷贝 records是
        BeanUtils.copyProperties(pageInfo, dishDtoInfo, "records");
        List<Dish> records = pageInfo.getRecords();
        // 将列表里面的元素赋值,扩展操作
        List<DishDto> dishDtoList = records.stream().map((item) -> {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item, dishDto);
            Long categoryId = item.getCategoryId();
            //根据id查询分类对象
            Category category = categoryService.getById(categoryId);
            if (category != null) {
                // 如果查出来的对象存在则开始赋值
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            return dishDto;
        }).collect(Collectors.toList());
        dishDtoInfo.setRecords(dishDtoList);
        return R.success(dishDtoInfo);
    }

    @GetMapping("/{id}")
    public R<DishDto> getDishDto(@PathVariable("id") Long id) {
        DishDto dishDto = dishService.getByIdWithFlavor(id);
        return R.success(dishDto);
    }

    @PutMapping
    public R<String> update(@RequestBody DishDto dishDto) {
        log.info("dishDto{}", dishDto);
        dishService.updateByIdWithFlavor(dishDto);
        return R.success("菜品内容修改成功！");
    }
}
