package com.codeking.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codeking.boot.entity.Setmeal;
import com.codeking.boot.entity.SetmealDto;

import java.util.List;

/**
 * @author : codeking
 * @create : 2022/12/23 20:11
 */
public interface SetmealService extends IService<Setmeal> {
    // 设置保存接口
    void saveWithDish(SetmealDto setmealDto);

    //修改停售状态
    void updateStatus(Setmeal setmeal);

    // 批量删除和单独删除
    void removeWithDish(List<Long> ids);
}
