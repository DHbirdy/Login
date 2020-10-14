package com.ceair.controller;

import com.ceair.entity.User;
import com.ceair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import com.ceair.controller.BaseController;

/**
 * @author lvpeng
 * @description
 * @date 2020/10/9-15:03
 */
@RestController
@CrossOrigin  //解决跨域问题
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("reg")
    public JsonResult<Object> reg( User user)  {
        userService.reg(user);
        return new JsonResult<>();
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User data = userService.login(username,password);
        session.setAttribute("uid",data.getId());
        session.setAttribute("username",data.getUsername());

        return new JsonResult<>();
    }
}
