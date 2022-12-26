package com.codeking.boot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.boot.entity.OrderDetail;
import com.codeking.boot.mapper.OrderDetailMapper;
import com.codeking.boot.mapper.OrderMapper;
import com.codeking.boot.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : codeking
 * @create : 2022/12/27 1:19
 */
@Service
@Slf4j
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
