package com.example.demo.controller;

import com.example.demo.Repository.MedicineRepository;
import com.example.demo.entity.MedicineEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medicine")
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

    /**
     * 查看列表
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<MedicineEntity> list() {
        return medicineRepository.findAll();
    }

    /**
     * 获得本人的药单
     */
    @ResponseBody
    @RequestMapping(value = "/mymedicine" , method = RequestMethod.POST)
    public List<Object> getlist(Integer Pa){
        System.out.println(Pa);
        return medicineRepository.findMyMedicine(Pa);
    }
    /**
     * 获得本人的药单
     */
    @ResponseBody
    @RequestMapping(value = "/mycount" , method = RequestMethod.POST)
    public List<Object> getCount(Integer Pa){
        System.out.println(Pa);
        return medicineRepository.findMyCount(Pa);
    }

    /**
     * 添加、更新
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public MedicineEntity save(MedicineEntity medicineEntity){
        return medicineRepository.saveAndFlush(medicineEntity);
    }

    /**
     * 删除药单
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public void delete(Integer InMno){
        medicineRepository.deleteByMno(InMno);
    }
}
