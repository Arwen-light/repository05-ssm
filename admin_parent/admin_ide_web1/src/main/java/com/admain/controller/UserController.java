package com.admain.controller;


import com.admin.domain.UserInfo;
import com.admin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAllUser() throws  Exception{

        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfo =  iUserService.findUsers();

        modelAndView.addObject("userList",userInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String saveUsers(UserInfo userInfo)throws Exception{

        iUserService.Save(userInfo);

        return  "redirect:findAll.do";
    }


    @RequestMapping("/findById")
    public ModelAndView findById(String id)throws Exception{

        UserInfo userInfo= iUserService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");

        return modelAndView;
    }

}
