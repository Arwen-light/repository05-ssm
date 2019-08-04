package com.admain.controller;


import com.admin.domain.Role;
import com.admin.domain.UserInfo;
import com.admin.service.IUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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

    // 查询userid信息和当前用户没有的角色的角色信息
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        // 查询当前用户的信息
        UserInfo userInfo = iUserService.findById(id);
        // 查询当前用户所没有的角色List 集合
        List<Role> roleList = iUserService.findOtherRoles(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }


    //http://localhost:8080/user/addRoleToUser.do
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(String userId,String[] ids)throws  Exception{

        iUserService.addRoleToUser(userId,ids);

        return  "redirect:findAll.do";
    }
}
