package com.ceair;

import com.ceair.entity.User;
import com.ceair.service.ServiceException;
import com.ceair.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lvpeng
 * @description
 * @date 2020/10/9-11:25
 */
@SpringBootTest
public class TestUserService {

    @Autowired(required = false)
    private UserService userService;

    @Test
    public void testSave(){
        User user1 = new User();
        user1.setUsername("丸子");
        user1.setPassword("123456");
        userService.save(user1);

    }


    @Test
    public void reg(){
        User user=new User();
        String username="zhang";
        String password="123456";
        user.setPassword(password);
        user.setUsername(username);
        userService.reg(user);

    }

    @Test
    public void login(){
        try {
            String username="root";
            String password ="1234";
            User Result=userService.login(username, password);
            System.err.println(Result);

        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }
}