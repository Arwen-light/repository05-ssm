package com.admin.service;

import com.admin.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll() throws  Exception;

    void save(Role role)throws Exception ;
}
