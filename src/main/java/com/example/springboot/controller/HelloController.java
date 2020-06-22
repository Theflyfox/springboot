package com.example.springboot.controller;

import com.example.springboot.entity.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/6/22 10:44
 */
@Controller
@RequestMapping()
public class HelloController {
    @Resource
    private Environment environment;
    @Autowired
    private MailProperties mailProperties;
    @RequestMapping("/say")
    @ResponseBody
    public String home() {
        System.out.println("get into");
        return "hello world";
    }

    @RequestMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "hello " + name;
    }

    @RequestMapping("/chinamap")
    public String chinamap() {
        System.out.println("chinamap！");
        return "/chinamap";
    }

    /**
     * 读取核心配置文件内容
     * @return
     */
    @RequestMapping("/env")
    @ResponseBody
    public String getEnvCOntent() {
        String content = environment.getProperty("spring.datasource.url");
        System.out.println(content);
        return content;
    }

    /**
     * 读取自定义
     * @return配置文件
     */
    @RequestMapping("/mailInfo")
    @ResponseBody
    public Map<String, Object> mailInfo() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("host", mailProperties.getHost());
        result.put("port", mailProperties.getPort());
        result.put("userName", mailProperties.getUsername());
        result.put("password", mailProperties.getPassword());
        return result;
    }
}
