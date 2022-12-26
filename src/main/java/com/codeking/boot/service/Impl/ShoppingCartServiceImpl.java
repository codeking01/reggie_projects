package com.codeking.boot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.boot.entity.ShoppingCart;
import com.codeking.boot.mapper.ShoppingCartMapper;
import com.codeking.boot.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * @author : codeking
 * @create : 2022/12/27 0:39
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
