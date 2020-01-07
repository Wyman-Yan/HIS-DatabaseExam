package com.example.demo.controller;

import com.example.demo.Repository.StorageRepository;
import com.example.demo.entity.StorageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/storage")
public class StorageController {

    @Autowired
    private StorageRepository storageRepository;

    /**
     * 查看列表
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<StorageEntity> list() {
        return storageRepository.findAll();
    }

    /**
     * 得到库存
     */
    @ResponseBody
    @RequestMapping(value = "/remain", method = RequestMethod.POST)
    public List<Object> Remain(String InSno) {
        return storageRepository.getRemain(InSno);
    }

    /**
     * 添加、更新
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public StorageEntity save(StorageEntity storageEntity){
        return storageRepository.save(storageEntity);
    }

}
