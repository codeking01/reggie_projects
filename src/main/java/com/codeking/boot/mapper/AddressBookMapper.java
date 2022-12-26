package com.codeking.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeking.boot.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : codeking
 * @create : 2022/12/26 16:12
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}
