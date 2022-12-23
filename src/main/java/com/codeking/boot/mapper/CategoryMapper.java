package com.codeking.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeking.boot.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : codeking
 * @create : 2022/12/23 19:34
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
