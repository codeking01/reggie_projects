package com.codeking.boot.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codeking.boot.common.R;
import com.codeking.boot.entity.Category;
import com.codeking.boot.entity.Dish;
import com.codeking.boot.entity.Setmeal;
import com.codeking.boot.entity.SetmealDto;
import com.codeking.boot.service.CategoryService;
import com.codeking.boot.service.DishService;
import com.codeking.boot.service.SetmealDishService;
import com.codeking.boot.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : codeking
 * @create : 2022/12/25 23:38
 */
@RestController
@RequestMapping("/setmeal")
@Slf4j
public class SetmealController {
    @Autowired
    private SetmealService setmealService;

    @Autowired
    private SetmealDishService setmealDishService;

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public R<String> save(@RequestBody SetmealDto setmealDto) {
        log.info("基本信息：{}", setmealDto);
        setmealService.saveWithDish(setmealDto);
        return R.success("保存成功！");
    }

    /**
     * 根据条件查询分页的内容
     *
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        //分页构造器对象
        Page<Setmeal> pageInfo = new Page<>(page, pageSize);
        Page<SetmealDto> setmealInfo = new Page<>(page, pageSize);
        //添加查询条件，根据name进行like模糊查询
        LambdaQueryWrapper<Setmeal> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(name != null, Setmeal::getName, name);
        // 添加排序条件
        lambdaQueryWrapper.orderByDesc(Setmeal::getUpdateTime);
        setmealService.page(pageInfo, lambdaQueryWrapper);
        // 拷贝数据
        BeanUtils.copyProperties(pageInfo, setmealInfo, "records");
        List<Setmeal> records = pageInfo.getRecords();
        List<SetmealDto> list = records.stream().map((item) -> {
            SetmealDto setmealDto = new SetmealDto();
            //对象拷贝
            BeanUtils.copyProperties(item, setmealDto);
            // 分类id
            Long categoryId = setmealDto.getCategoryId();
            //根据分类id查询分类对象
            Category category = categoryService.getById(categoryId);
            // 查到有内容在开始赋值
            if (category != null) {
                // 设置名字
                setmealDto.setCategoryName(category.getName());
            }
            return setmealDto;
        }).collect(Collectors.toList());
        // 设置新的信息
        setmealInfo.setRecords(list);
        return R.success(setmealInfo);
    }

    @PostMapping("/status/{status}")
    public R<String> updateStatus(@PathVariable Integer status,@RequestParam("ids") Long id) {
        log.info("id:{}", id);
        // 从数据库查出数据
        LambdaQueryWrapper<Setmeal> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Setmeal::getId,id);
        Setmeal setmeal = setmealService.getOne(lambdaQueryWrapper);
        if (setmeal!=null){
            setmeal.setStatus(status);
            setmealService.updateStatus(setmeal);
            return R.success("修改停售状态成功！");
        }
        return R.error("查询不到信息..");
    }
    /**
     * 删除套餐
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> delete(@RequestParam("ids") List<Long> ids){
        log.info("ids:{}",ids);
        setmealService.removeWithDish(ids);
        return R.success("套餐数据删除成功");
    }
}
