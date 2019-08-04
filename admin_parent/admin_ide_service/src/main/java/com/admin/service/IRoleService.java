package com.admin.service;

import com.admin.domain.Permission;
import com.admin.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String id) throws Exception;

    List<Permission> findOtherPermissions(String id) throws Exception;

    void addPermissionToRole(String roleId, String[] ids) throws Exception;

}
