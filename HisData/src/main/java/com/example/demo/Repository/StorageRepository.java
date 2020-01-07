package com.example.demo.Repository;

import com.example.demo.entity.StorageEntity;
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
public interface StorageRepository extends
        JpaRepository<StorageEntity,Long>,
        JpaSpecificationExecutor<StorageEntity>,
        Serializable {

    @Query(value = "select * from Storage where Storage.Sno = :InSno",nativeQuery = true)
    List<Object> getRemain(@Param("InSno") String InSno);
}
