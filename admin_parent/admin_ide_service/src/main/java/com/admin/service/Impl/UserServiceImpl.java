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
                return new User(userInfor.getUsername(), "{noop}" + userInfor.getPassword(),
                       userInfor.getStatus()==1?true:false ,true,true,true,
                        getAuthrorities(userInfor.getRoles()) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<SimpleGrantedAuthority> getAuthrorities(List<Role> roles){

        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
       /* authorities.add(new SimpleGrantedAuthority("ROLE_USER"));  //ROLE_USER*/
        for (Role role : roles) {
            String roleName = role.getRoleName();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roleName));
        }
        return authorities;
    }

}
