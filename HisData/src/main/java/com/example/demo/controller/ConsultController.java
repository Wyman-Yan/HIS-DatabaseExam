package com.example.demo.controller;


import com.example.demo.Repository.ConsultRepository;
import com.example.demo.entity.ConsultEntity;
import com.example.demo.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/consult")
public class ConsultController {

    @Autowired
    private ConsultRepository consultRepository;

    /**
     * 查看列表
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<ConsultEntity> list() {
        return consultRepository.findAll();
    }
    /**
     * 查看列表详细信息
     */
    @ResponseBody
    @RequestMapping(value = "/listall", method = RequestMethod.GET)
    public List<Object> ShowAll(){
        return consultRepository.RecordShowAll();
    }
    /**
     * 按医生查找
     */
    @ResponseBody
    @RequestMapping(value = "/serach", method = RequestMethod.POST)
    public List<Object> ConsultByDoctor(int InDno){
        System.out.println(InDno);
        return consultRepository.ConsultByDoctor(InDno);
    }
    /**
     * 模糊查找
     */
    @ResponseBody
    @RequestMapping(value = "/mohuSearch", method = RequestMethod.POST)
    public List<Object> MohuSearch(String Mohu){
        return consultRepository.RecordSearch(Mohu);
    }

    /**
     * 添加、更新
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ConsultEntity save(ConsultEntity consultEntity){
        return consultRepository.save(consultEntity);
    }
}
