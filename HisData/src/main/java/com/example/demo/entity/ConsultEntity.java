package com.example.demo.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Consult")
public class ConsultEntity implements Serializable {
    @Id
    @Column(name = "Cno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Cno;

    @Column(name = "Pno")
    private int Pno;

    @Column(name = "Dno")
    private int Dno;

    @Column(name = "CDate")
    private String CDate;

    public int getCno() {
        return Cno;
    }

    public int getPno() {
        return Pno;
    }

    public int getDno() {
        return Dno;
    }



    public void setCno(int cno) {
        Cno = cno;
    }

    public void setPno(int pno) {
        Pno = pno;
    }

    public void setDno(int dno) {
        Dno = dno;
    }

    public String getCDate() {
        return CDate;
    }

    public void setCDate(String CDate) {
        this.CDate = CDate;
    }
}
