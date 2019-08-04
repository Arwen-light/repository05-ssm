package com.admin.domain;

import java.util.List;

public class Permission {
    //id             VARCHAR2(32) default SYS_GUID() not null,
    //  permissionname VARCHAR2(50),
    //  url            VARCHAR2(50)

    private  String id;
    private  String permissionName;
    private  String url;
    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
