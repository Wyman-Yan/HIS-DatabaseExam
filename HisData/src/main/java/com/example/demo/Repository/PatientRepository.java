package com.example.demo.Repository;

import com.example.demo.entity.PatientEntity;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public interface PatientRepository extends
        JpaRepository<PatientEntity,Long>,
        JpaSpecificationExecutor<PatientEntity>,
        Serializable {
    @Query(value = "select count(*) from Patient",nativeQuery = true)
    Integer PatientNum();

    @Query(value = "select * from Patient where Patient.Pno = :MyP",nativeQuery = true)
    List<Object> GetMy(@Param("MyP") Long MyP);

}
