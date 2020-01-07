package com.example.demo.Repository;


import com.example.demo.entity.ConsultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public interface ConsultRepository extends
        JpaRepository<ConsultEntity,Long>,
        JpaSpecificationExecutor<ConsultEntity>,
        Serializable {
    @Query(value = "select Patient.Pno,Patient.Pname,Patient.Psex,Consult.CDate,Doctor.Dsection from Patient,Consult," +
            "Doctor where Patient.Pno=Consult.Pno and Doctor.Dno = Consult.Dno",nativeQuery = true)
    List<Object> RecordShowAll();

    @Query(value = "select Patient.Pno,Patient.Pname,Patient.Psex,Consult.CDate,Doctor.Dsection from Patient,Consult," +
            "Doctor where Patient.Pno=Consult.Pno and Doctor.Dno = Consult.Dno and Patient.Pname like CONCAT('%'," +
            ":Mohu," +
            "'%')",
            nativeQuery =
            true)
    List<Object> RecordSearch(@Param("Mohu") String Mohu);

    @Query(value = "select Consult.Cno,Consult.Pno,Consult.CDate,Doctor.Dno,Doctor.Dsection,Patient.Pname from " +
            "Patient,Consult," +
            "Doctor" +
            " where " +
            "Consult.Pno = Patient.Pno and Consult.Dno=Doctor.Dno " +
            "and " +
            "Consult.Dno = " +
            ":InDno",
            nativeQuery = true)
    List<Object> ConsultByDoctor(@Param("InDno") int InDno);
}
