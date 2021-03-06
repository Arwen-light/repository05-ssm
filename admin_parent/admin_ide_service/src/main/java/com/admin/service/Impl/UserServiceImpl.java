package com.admin.service.Impl;

import com.admin.dao.IUserDao;
import com.admin.domain.Role;
import com.admin.domain.UserInfo;
import com.admin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {


    @Autowired
    private IUserDao iUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            UserInfo userInfor = iUserDao.findUserByUserName(username);

            if (userInfor != null) {
                return new User(userInfor.getUsername(), userInfor.getPassword(),
                        userInfor.getStatus() == 1 ? true : false, true, true, true,
                        getAuthrorities(userInfor.getRoles()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<SimpleGrantedAuthority> getAuthrorities(List<Role> roles) {

        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        /* authorities.add(new SimpleGrantedAuthority("ROLE_USER"));  //ROLE_USER*/
        for (Role role : roles) {
            String roleName = role.getRoleName();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roleName));
        }
        return authorities;
    }

    @Override
    public List<UserInfo> findUsers() throws Exception {

        List<UserInfo> userList = iUserDao.findAll();
        return userList;
    }

    // userinfo 有关密码明文和密文转化处理的问题
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void Save(UserInfo userInfo) throws Exception {
        String cryptpassword = bCryptPasswordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(cryptpassword);
        iUserDao.save(userInfo);

    }

    @Override
    public UserInfo findById(String id) throws Exception {
        UserInfo userInfo = iUserDao.findById(id);
        return userInfo;
    }

    @Override
    public List<Role> findOtherRoles(String id) throws Exception {

        return iUserDao.findOtherRoles(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) throws Exception {
        for (String id : ids) {
            iUserDao.addRoleToUser(id,userId);
        }
    }
}
