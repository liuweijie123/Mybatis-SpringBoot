package com.ouyang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ouyang.mapper.UserMapper;
import com.ouyang.model.User;

import ch.qos.logback.classic.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;


/**
 * Created by Duning Ouyang on 2017/4/9.
 */
@Service
public class UserService{
    @Autowired
    UserMapper userMapper;
    public List<User> getAll() {
    	return userMapper.selectAll();
    }
    
    public PageInfo<User> getAllByPage() {
    	PageHelper.startPage(2, 2);
    	List<User> list = userMapper.selectAll();
    	PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    
    @Transactional
    public int delete(){
    	int i = 0;
    		userMapper.deleteByPrimaryKey("12");
    		i = 2/0;
    	return i;
    }
}
