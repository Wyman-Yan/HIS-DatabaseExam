package com.example.demo.entity;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class UserEntity implements Serializable {
    @Id
    @Column(name = "Uno")
    @ApiModelProperty(value = "用户编号", name = "Uno", required = false)
    private Long Uno;

    @Column(name = "Uname")
    @ApiModelProperty(value = "用户姓名", name = "Uname", required = false)
    private String Uname;

    @Column(name = "Upwd")
    private String Upwd;
    @Column(name = "Uide")
    private String Uide;

    public Long getUno() {
        return Uno;
    }

    public String getUname() {
        return Uname;
    }

    public String getUpwd() {
        return Upwd;
    }

    public String getUide() {
        return Uide;
    }

    public void setUno(Long uno) {
        Uno = uno;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public void setUpwd(String upwd) {
        Upwd = upwd;
    }

    public void setUide(String uide) {
        Uide = uide;
    }
}
