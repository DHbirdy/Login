package com.ceair.dao;

import com.ceair.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lvpeng
 * @description
 * @date 2020/10/9-11:11
 */
@Mapper
public interface UserDao {

    //保存用户信息
    void save(User user);

/**
 * @author: lvpeng
 * @description: 根据id查找用户
 * @date: 2020/10/9
 * @param:  id
 * @return:  user
 */
    User findById(Integer id);

    User findByUsername(String username);
}
