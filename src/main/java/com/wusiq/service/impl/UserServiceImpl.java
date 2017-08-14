package com.wusiq.service.impl;

import com.wusiq.dao.UserDao;
import com.wusiq.entity.UserEntity;
import com.wusiq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户管理服务的实现类
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean addRow(UserEntity t) {
        return userDao.addRow(t);
    }

    @Override
    public void deleteRow(UserEntity t) {
        userDao.deleteRow(t);
    }

    @Override
    public void updateRow(UserEntity t) {
         userDao.updateRow(t);
    }

    @Override
    public UserEntity queryRow(int id) {
        return userDao.queryRow(id);
    }

    @Override
    public List<UserEntity> queryRowList() {
        return userDao.queryRowList();
    }
}
