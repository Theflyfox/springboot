package com.example.springboot.controller;

import com.example.springboot.dao.UserRepository;
import com.example.springboot.entity.TestDataPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/6/22 11:24
 */
@RestController
@RequestMapping("/hibernate")
@EnableAutoConfiguration
public class HibernateController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getById")
    public Optional<TestDataPO> getById(Long id) {
        Optional<TestDataPO> optional = userRepository.findById(id);
        System.out.println("userRepository" + userRepository);
        System.out.println("id" + id);
        return optional;
    }

    @GetMapping("/save")
    public TestDataPO save() {
        TestDataPO po = new TestDataPO();
        po.setCardId("31012119804072341");
        po.setSex("女");
        po.setCreateDate(new Date());
        po.setAge(40);
        po.setBirth(new Date());
        po.setTelephone("18728901923");
        po = userRepository.save(po);
        return po;
    }
}


