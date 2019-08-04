package com.admin.service;

import com.admin.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

   // 查询所有的users
    List<UserInfo> findUsers() throws  Exception;

    void Save(UserInfo userInfo) throws  Exception;

    UserInfo findById(String id)throws Exception;
}
