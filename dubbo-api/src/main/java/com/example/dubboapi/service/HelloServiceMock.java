package com.example.dubboapi.service;

import com.example.dubboapi.model.User;

/**
 * <p>Title: com.example.dubboapi.service.HelloServiceMock </p>
 *
 * <p>Description:  </p>
 *
 * <p>Company: </p>
 *
 * <p>date: 2021/2/3 10:17 </p>
 *
 * @author: jt-ape
 */
public class HelloServiceMock implements HelloService{
    @Override
    public String sayHello(String name) {
        return "额 我是一个伪装者";
    }

    @Override
    public User sayHello() {
        return null;
    }
}
