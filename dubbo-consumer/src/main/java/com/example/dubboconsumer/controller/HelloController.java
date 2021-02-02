package com.example.dubboconsumer.controller;

import com.example.dubboapi.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: com.example.dubboconsumer.controller.HelloController </p>
 *
 * <p>Description:  </p>
 *
 * <p>Company: </p>
 *
 * <p>date: 2021/2/1 23:41 </p>
 *
 * @author: jt-ape
 */
@RestController
public class HelloController {
    @Reference(loadbalance = "random",timeout = 4000)
    private HelloService helloService;
    @RequestMapping("/say")
    public String say() {
        String result = helloService.sayHello("hahahaha");
        System.out.println(result);
        return result;
    }
}
