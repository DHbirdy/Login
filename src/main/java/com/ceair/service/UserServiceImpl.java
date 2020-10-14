package com.ceair.service;

import com.ceair.dao.UserDao;
import com.ceair.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lvpeng
 * @description
 * @date 2020/10/9-11:22
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired(required = false)

    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User login(String username, String password) {
        User result=userDao.findByUsername(username);

        if(result == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        if(!password.equals(result.getPassword())){
            throw new PasswordNotException("密码错误");
        }

        User user =new User();
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }

    @Override
    public void reg(User user) {
        System.out.print(user.getUsername());
        System.out.print(user.getPassword());
        //判断用户名是否为null
        String username = user.getUsername();
        User result = userDao.findByUsername(username);

        if(result != null){
            throw new UsernameNotFoundException("注册名被占用");
        }

        String password=user.getPassword();
        user.setUsername(username);
        user.setPassword(password);


        System.out.print(result);

        userDao.save(user);
    }
}
