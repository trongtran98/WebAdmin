package com.seatech.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_ROLE")
public class Role {

    @Id
    @Column(name = "ROLEID")
    private String roleId;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @ManyToMany
    @JoinTable(name = "T_USER_ROLE",
            joinColumns = @JoinColumn(name = "ROLEID"),
            inverseJoinColumns = @JoinColumn(name = "USERNAME"))
    private Set<User> users;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
