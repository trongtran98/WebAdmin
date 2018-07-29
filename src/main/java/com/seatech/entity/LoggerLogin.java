package com.seatech.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "T_LOGIN_LOGGER")
public class LoggerLogin {
    @Id
    @Column(name = "LGID")
    private String lgId;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIME")
    private Date time;
    @JoinColumn(name = "USERNAME")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public String getLgId() {
        return lgId;
    }

    public void setLgId(String lgId) {
        this.lgId = lgId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
