package com.codeking.boot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.boot.entity.Setmeal;
import com.codeking.boot.mapper.SetmealMapper;
import com.codeking.boot.service.SetmealService;
import org.springframework.stereotype.Service;

/**
 * @author : codeking
 * @create : 2022/12/23 20:12
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
