package com.codeking.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeking.boot.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : codeking
 * @create : 2022/12/27 0:38
 */
@Mapper
public interface  ShoppingCartMapper extends BaseMapper<ShoppingCart> {
}
