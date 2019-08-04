package com.admin.service.Impl;

import com.admin.dao.IRoleDao;
import com.admin.domain.Permission;
import com.admin.domain.Role;
import com.admin.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public List<Role> findAll() throws Exception {
        List<Role> roleList =  iRoleDao.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) throws Exception {
        iRoleDao.save(role);
    }

    @Override
    public Role findById(String id) throws Exception {
        return iRoleDao.findById(id);
    }

    @Override
    public List<Permission> findOtherPermissions(String id) throws Exception {
        List<Permission>  listPermission=  iRoleDao.findOtherPermissions(id);
        return listPermission;
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) throws Exception {
        for (String id : ids) {

            iRoleDao.addPermissionToRole(roleId,id);

        }

    }
}
