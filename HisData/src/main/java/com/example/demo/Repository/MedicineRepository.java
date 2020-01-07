package com.example.demo.Repository;

import com.example.demo.entity.MedicineEntity;
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
public interface MedicineRepository extends
        JpaRepository<MedicineEntity,Long>,
        JpaSpecificationExecutor<MedicineEntity>,
        Serializable {

    @Query(value = "select * from V_Medicine where V_Medicine.Pno = :Pa ",nativeQuery =
            true)
    List<Object> findMyMedicine(@Param("Pa") Integer Pa);

    @Query(value = "select count(*) from Medicine,Consult,Storage" +
            " where " +
            "Medicine" +
            ".Sno=Storage.Sno and Medicine.Cno=Consult.Cno and Medicine.Pno = :Pa group by Medicine.Cno",nativeQuery =
            true)
    List<Object> findMyCount(@Param("Pa") Integer Pa);

    @Query(value = "delete from Medicine where Medicine.Mno = :InMno",nativeQuery = true)
    @Modifying
    void deleteByMno(@Param("InMno") Integer InMno);
}
