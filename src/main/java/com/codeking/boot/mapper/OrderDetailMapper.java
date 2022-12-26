package com.codeking.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeking.boot.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : codeking
 * @create : 2022/12/27 1:17
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
}
