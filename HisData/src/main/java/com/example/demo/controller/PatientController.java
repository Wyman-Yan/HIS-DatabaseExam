package com.example.demo.controller;

import com.example.demo.Repository.PatientRepository;
import com.example.demo.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    /**
     * 查看列表
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<PatientEntity> list() {
        return patientRepository.findAll();
    }

    /**
     * 查看病人数量
     */
    @RequestMapping(value = "/patientnum",method =  RequestMethod.GET)
    public int getpatientNum(){
        return patientRepository.PatientNum();
    }

    /**
     * 查看自己的信息
     */
    @RequestMapping(value = "/mymess",method =  RequestMethod.POST)
    public List<Object> getMy(Long MyP){
        return patientRepository.GetMy(MyP);
    }

    /**
     * 添加、更新
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public PatientEntity save(PatientEntity patientEntity){
        return patientRepository.save(patientEntity);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete" , method = RequestMethod.GET)
    public List<PatientEntity> delete(Long Pno){
        patientRepository.deleteById(Pno);
        return patientRepository.findAll();
    }
}
