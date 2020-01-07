package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Storage")
public class StorageEntity {
    @Id
    @Column(name = "Sno")
    private String Sno;

    @Column(name = "Sname")
    private String Sname;

    @Column(name = "Scount")
    private int Scount;

    @Column(name = "Svalue")
    private int Svalue;

    public String getSno() {
        return Sno;
    }

    public String getSname() {
        return Sname;
    }

    public int getScount() {
        return Scount;
    }

    public int getSvalue() {
        return Svalue;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public void setScount(int scount) {
        Scount = scount;
    }

    public void setSvalue(int svalue) {
        Svalue = svalue;
    }
}
