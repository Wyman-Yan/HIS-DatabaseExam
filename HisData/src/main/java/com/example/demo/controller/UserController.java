package com.example.demo.controller;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.UserEntity;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查看列表
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "列表", notes = "获取用户列表", httpMethod = "GET")
    public List<UserEntity> list() {
        return userRepository.findAll();
    }

    /**
     * 查看某个用户
     */
    @RequestMapping(value = "/singleuser",method = RequestMethod.POST)
    @ApiOperation(value = "某用户信息", notes = "查看某个用户", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数Uno没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public Optional<UserEntity> sigle(Long Uno){
        System.out.println(Uno);
        return userRepository.findById(Uno);
    }
    /**
     * 查看用户名
     */
    @RequestMapping(value = "/username",method = RequestMethod.POST)
    public String sigle(Integer InUno){
        System.out.println(InUno);
        return userRepository.findName(InUno);
    }

    /**
     * 添加、更新
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public UserEntity save(UserEntity userEntity){
        System.out.println(userEntity.getUname());
        return userRepository.saveAndFlush(userEntity);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete" , method = RequestMethod.GET)
    public List<UserEntity> delete(Long Uno){
        userRepository.deleteById(Uno);
        return userRepository.findAll();
    }
}
