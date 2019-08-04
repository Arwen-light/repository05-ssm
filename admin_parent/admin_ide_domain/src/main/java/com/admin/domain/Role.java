package com.admin.domain;


import java.util.List;

public class Role {
    // id       VARCHAR2(32) default SYS_GUID() not null,
    //  rolename VARCHAR2(50),
    //  roledesc VARCHAR2(50)

    private String id;
    private String roleName;
    private String roleDesc;
    private List<UserInfo> users;
    private List<Permission> permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
