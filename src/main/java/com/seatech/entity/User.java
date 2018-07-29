package com.seatech.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_USER")
public class User {
    @Id
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "user")
    private Set<LoggerLogin> loggerLogins;
    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<LoggerLogin> getLoggerLogins() {
        return loggerLogins;
    }

    public void setLoggerLogins(Set<LoggerLogin> loggerLogins) {
        this.loggerLogins = loggerLogins;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
