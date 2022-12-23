package com.codeking.boot.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codeking.boot.common.R;
import com.codeking.boot.entity.Category;
import com.codeking.boot.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : codeking
 * @create : 2022/12/23 19:38
 */
@Slf4j
@RequestMapping("/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public R<String> save(@RequestBody Category category){
        log.info("category:{}",category);
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    // 分页查询
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize) {
        //分页构造器
        Page<Category> pageInfo =new Page<>(page, pageSize);
        //条件构造器
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加排序条件，根据sort进行排序
        lambdaQueryWrapper.orderByAsc(Category::getSort);
        //分页查询
        categoryService.page(pageInfo,lambdaQueryWrapper);
        return R.success(pageInfo);
    }

    /**
     * 根据id删除分类
     * @param id
     * @return
     */
    @DeleteMapping
    public R<String> delete(@RequestParam("ids") Long id) {
        log.info("删除分类，id为：{}",id);
        categoryService.remove(id);
        return R.success("分类信息——删除成功！");
    }

    /**
     * 根据id修改分类信息
     * @param category
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Category category) {
        log.info("category:{}",category);
        categoryService.updateById(category);
        return R.success("修改管理内容成功！");
    }
}