package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Doctor")
public class WorkerEntity implements Serializable {
    @Id
    @Column(name = "Dno")
    private int Dno;
    @Column(name = "Dname")
    private String Dname;
    @Column(name = "Dsex")
    private String Dsex;
    @Column(name = "Dage")
    private int Dage;
    @Column(name = "Dsection")
    private  String Dsection;
    @Column(name = "Dtel")
    private Long Dtel;

    public int getDno() {
        return Dno;
    }

    public String getDname() {
        return Dname;
    }

    public String getDsex() {
        return Dsex;
    }

    public int getDage() {
        return Dage;
    }

    public String getDsection() {
        return Dsection;
    }

    public Long getDtel() {
        return Dtel;
    }

    public void setDno(int dno) {
        Dno = dno;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public void setDsex(String dsex) {
        Dsex = dsex;
    }

    public void setDage(int dage) {
        Dage = dage;
    }

    public void setDsection(String dsection) {
        Dsection = dsection;
    }

    public void setDtel(Long dtel) {
        Dtel = dtel;
    }
}
