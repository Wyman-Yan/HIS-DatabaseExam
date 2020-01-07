package com.example.demo.Repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;

public interface UserRepository extends
        JpaRepository<UserEntity,Long>,
        JpaSpecificationExecutor<UserEntity>,
        Serializable {

    @Query(value = "select Uname from User where User.Uno = :InUno",nativeQuery = true)
    String findName(@Param("InUno") Integer InUno);
}
