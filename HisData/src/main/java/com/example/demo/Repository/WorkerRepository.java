package com.example.demo.Repository;

import com.example.demo.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public interface WorkerRepository extends
        JpaRepository<WorkerEntity,Long>,
        JpaSpecificationExecutor<WorkerEntity>,
        Serializable {
    @Query(value = "select Dno,Dname from Doctor",nativeQuery = true)
    List<String> findAllDoctorName();
}
