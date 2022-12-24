package com.codeking.boot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.boot.entity.DishFlavor;
import com.codeking.boot.mapper.DishFlavorMapper;
import com.codeking.boot.service.DishFlavorService;
import org.springframework.stereotype.Service;

/**
 * @author : codeking
 * @create : 2022/12/24 21:35
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
