package com.codeking.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codeking.boot.entity.Category;

/**
 * @author : codeking
 * @create : 2022/12/23 19:35
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
