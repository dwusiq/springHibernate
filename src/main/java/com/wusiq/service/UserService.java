package com.wusiq.service;

import com.wusiq.entity.UserEntity;

import java.util.List;

/**
 * 用户管理的服务类
 */
public interface UserService {
    /*增*/
    boolean addRow(UserEntity t);
    /*删*/
    void deleteRow(UserEntity t);
    /*改*/
    void updateRow(UserEntity t);
    /*查*/
    UserEntity queryRow(int id);
    /*查*/
    List<UserEntity> queryRowList();
}
