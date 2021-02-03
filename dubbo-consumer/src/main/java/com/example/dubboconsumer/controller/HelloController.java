package com.example.dubboconsumer.controller;

import com.example.dubboapi.listener.CallBackListener;
import com.example.dubboapi.model.User;
import com.example.dubboapi.service.HelloService;
import com.example.dubboconsumer.callback.CallBackListenerImpl;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

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
    @Reference(loadbalance = "roundrobin",timeout = 4000,mock = "fail: return 111")
    private HelloService helloService;
    @RequestMapping("/say")
    public String say() {
        String result = helloService.sayHello("hahahaha");
        System.out.println(result);
        return result;
    }

    @RequestMapping("/user")
    public String say1() {
        User result = helloService.sayHello();
        System.out.println(result);
        return result.getName();
    }

    @RequestMapping("/callback")
    public String say2() {
        return helloService.sayHello(new CallBackListener() {
            @Override
            public String callBack() {
                return "通过回调方法返回客户端的东西";
            }
        });
    }

}
