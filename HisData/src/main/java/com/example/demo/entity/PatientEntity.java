package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Patient")
public class PatientEntity implements Serializable {
    @Id
    @Column(name = "Pno")
    private Long Pno;

    @Column(name = "Pname")
    private String Pname;

    @Column(name = "Psex")
    private String Psex;

    @Column(name = "Page")
    private int Page;

    @Column(name = "Paddr")
    private String Paddr;

    @Column(name = "Ptel")
    private Long Ptel;

    public Long getPno() {
        return Pno;
    }

    public String getPname() {
        return Pname;
    }

    public String getPsex() {
        return Psex;
    }

    public int getPage() {
        return Page;
    }

    public String getPaddr() {
        return Paddr;
    }

    public Long getPtel() {
        return Ptel;
    }

    public void setPno(Long pno) {
        Pno = pno;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public void setPsex(String psex) {
        Psex = psex;
    }

    public void setPage(int page) {
        Page = page;
    }

    public void setPaddr(String paddr) {
        Paddr = paddr;
    }

    public void setPtel(Long ptel) {
        Ptel = ptel;
    }
}
