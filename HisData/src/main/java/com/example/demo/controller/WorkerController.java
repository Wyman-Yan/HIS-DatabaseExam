package com.example.demo.controller;

import com.example.demo.entity.WorkerEntity;
import com.example.demo.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/worker")
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    /**
     * 查看医生列表
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<WorkerEntity> list() {
        return workerRepository.findAll();
    }
    /**
     * 返回所有医生名字
     */
    @ResponseBody
    @RequestMapping(value = "/namelist", method = RequestMethod.GET)
    public List<String> nameList(){
        return workerRepository.findAllDoctorName();
    }

    /**
     * 添加、更新医生
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public WorkerEntity save(WorkerEntity workerEntity){
        return workerRepository.save(workerEntity);
    }

    /**
     * 删除医生
     */
    @RequestMapping(value = "/delete" , method = RequestMethod.GET)
    public List<WorkerEntity> delete(WorkerEntity workerEntity){
        workerRepository.delete(workerEntity);
        return workerRepository.findAll();
    }
}
