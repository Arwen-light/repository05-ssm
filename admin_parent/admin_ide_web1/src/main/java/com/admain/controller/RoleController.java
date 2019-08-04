package com.admain.controller;


import com.admin.domain.Permission;
import com.admin.domain.Role;
import com.admin.domain.UserInfo;
import com.admin.service.IRoleService;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = iRoleService.findAll();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String saveRole(Role role) throws Exception {

        iRoleService.save(role);

        return "redirect:findAll.do";
    }


    // 查询Roleid信息和当前用户没有的角色的角色信息
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        // 查询当前角色的信息
        Role role = iRoleService.findById(id);
        // 查询当前角色所没有的资源配置List集合
        List<Permission> permissionList = iRoleService.findOtherPermissions(id);
        modelAndView.addObject("role", role);
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }


    //addPermissionToRole.do
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(String roleId, String[] ids) throws Exception {
        iRoleService.addPermissionToRole(roleId, ids);
        return "redirect:/role/findAll.do";
    }
}
