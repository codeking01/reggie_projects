package com.codeking.boot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.boot.entity.AddressBook;
import com.codeking.boot.mapper.AddressBookMapper;
import com.codeking.boot.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * @author : codeking
 * @create : 2022/12/26 16:14
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
