package com.codeking.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codeking.boot.entity.Orders;

/**
 * @author : codeking
 * @create : 2022/12/27 1:18
 */
public interface OrderService extends IService<Orders> {
    void submit(Orders orders);
}
