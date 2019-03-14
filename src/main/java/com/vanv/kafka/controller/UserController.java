package com.vanv.kafka.controller;

import com.vanv.kafka.domain.User;
import com.vanv.kafka.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    //依赖注入
    @Autowired
    IUserService userService;

    @RequestMapping(value="/login")
    public String login(User user) {
        //调用dao层
        System.out.println("前端"+user);
        User u = userService.getUser(user.getUsername());
        System.out.println("数据库"+u);
        if (u.getPassword().equals(user.getPassword())){
            return "success";
        }
        return "fail";
    }


}



