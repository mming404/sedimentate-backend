package com.ysm.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/24
 * @Version V1.0
 **/
@RestController
public class TestController {

    @Autowired
    private UserServiceTest userServiceTest;

    @GetMapping("/test")
    public String test(){
        System.out.println("方法执行中。。。");
        userServiceTest.test1();
        return "ok";
    }
}
