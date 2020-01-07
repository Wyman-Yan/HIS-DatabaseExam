package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")
public class BookingEntity {

    @Id
    @Column(name = "Bno")
    private int Bno;

    @Column(name = "BDay")
    private String BDay;

    @Column(name = "Pno")
    private int Pno;

    @Column(name = "Dno")
    private int Dno;

    public int getBno() {
        return Bno;
    }

    public String getBDay() {
        return BDay;
    }

    public int getPno() {
        return Pno;
    }

    public int getDno() {
        return Dno;
    }

    public void setBno(int bno) {
        Bno = bno;
    }

    public void setBDay(String BDay) {
        this.BDay = BDay;
    }

    public void setPno(int pno) {
        Pno = pno;
    }

    public void setDno(int dno) {
        Dno = dno;
    }
}
