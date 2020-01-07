package com.example.demo.controller;


import com.example.demo.Repository.BookingRepository;
import com.example.demo.entity.BookingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;


    /**
     * 查看列表
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<BookingEntity> list() {
        return bookingRepository.findAll();
    }
    /**
     * 按医生查找
     */
    @ResponseBody
    @RequestMapping(value = "/serach", method = RequestMethod.POST)
    public List<BookingEntity> BookingByDoctor(int InDno){
        System.out.println(InDno);
        return bookingRepository.BookingByDoctor(InDno);
    }
    /**
     * show诊治单
     */
    @ResponseBody
    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public Object BookingShow(int InDno){
        return bookingRepository.BookingShow(InDno);
    }
    /**
     * Nurse查看预约
     */
    @ResponseBody
    @RequestMapping(value = "/showall", method = RequestMethod.POST)
    public Object BookingShowAll(){
        return bookingRepository.BookingShowAll();
    }

    /**
     * 添加、更新
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public BookingEntity save(BookingEntity bookingEntity){
        return bookingRepository.save(bookingEntity);
    }

    /**
     * 根据诊单号删除预约
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public void deleteByBno(int Bno){
        bookingRepository.deleteByBno(Bno);
    }
}
