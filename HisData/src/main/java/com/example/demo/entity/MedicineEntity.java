package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medicine")
public class MedicineEntity {
    @Id
    @Column(name = "Mno")
    private int Mno;

    @Column(name = "Pno")
    private int Pno;

    @Column(name = "Sno")
    private String Sno;

    @Column(name = "Mnum")
    private int Mnum;

    @Column(name = "Cno")
    private int Cno;

    public int getMno() {
        return Mno;
    }

    public String getSno() {
        return Sno;
    }

    public int getMnum() {
        return Mnum;
    }

    public int getCno() {
        return Cno;
    }

    public void setMno(int mno) {
        Mno = mno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public void setMnum(int mnum) {
        Mnum = mnum;
    }

    public void setCno(int cno) {
        Cno = cno;
    }

    public int getPno() {
        return Pno;
    }

    public void setPno(int pno) {
        Pno = pno;
    }
}
