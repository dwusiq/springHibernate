package com.wusiq.dao.impl;

import com.wusiq.dao.UserDao;
import com.wusiq.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Dao实现类
 */
@Repository
public class UserDaoImpl implements UserDao {
    private static Logger LOGGER =  LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    /*获取当前会话*/
    private Session currentSession(){
        return sessionFactory.openSession();
    }

    /*添加*/
    @Override
    public boolean addRow(UserEntity userEntity) {
        Serializable id = this.currentSession().save(userEntity);
        LOGGER.info("save return id:"+id);
        if(null != id){
            return true;
        }
        return false;
    }

    /*删除*/
    @Override
    public void deleteRow(UserEntity userEntity) {
        this.currentSession().delete(userEntity);
    }

   /*改*/
    @Override
    public void updateRow(UserEntity userEntity) {
        this.currentSession().update(userEntity);
    }

    /*查*/
    @Override
    public UserEntity queryRow(int id) {
        UserEntity userEntity = (UserEntity)this.currentSession().get(UserEntity.class,id);
        return userEntity;
    }

    /*查List*/
    @Override
    public List<UserEntity> queryRowList() {
        List<UserEntity> list = (List<UserEntity>)this.currentSession().createCriteria(UserEntity.class).list();
        return list;
    }
}


