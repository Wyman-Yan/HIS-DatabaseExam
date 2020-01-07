package com.example.demo.Repository;

import com.example.demo.entity.BookingEntity;
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
public interface BookingRepository extends
        JpaRepository<BookingEntity,Long>,
        JpaSpecificationExecutor<BookingEntity>,
        Serializable {
    @Query(value = "select * from Booking where Dno = :InDno group by Booking.Bno",nativeQuery = true)
    List<BookingEntity> BookingByDoctor(@Param("InDno") int InDno);

    @Query(value = "select Patient.Pname,Booking.Pno,Booking.Bno,Booking.BDay,Doctor.Dno,Doctor.Dsection " +
            "from " +
            "Patient," +
            "Booking," +
            "Doctor " +
            "where " +
            "Booking.Pno = Patient.Pno and Booking.Dno = Doctor.Dno and Booking.Dno = :InDno",nativeQuery = true)
    List<Object> BookingShow(@Param("InDno") int Dno);

    @Query(value = "select Patient.Pname,Booking.Pno,Booking.Bno,Doctor.Dno,Booking.BDay,Doctor.Dsection from Patient," +
            "Booking,Doctor where Booking.Pno = Patient.Pno and Booking.Dno = Doctor.Dno",nativeQuery = true)
     List<Object> BookingShowAll();

    @Query(value = "delete from Booking where Bno = :InBno",nativeQuery = true)
    @Modifying
    void deleteByBno(@Param("InBno") int InBno);
}
