package com.example.dubboapi.service;

import com.example.dubboapi.listener.CallBackListener;
import com.example.dubboapi.model.User;

import java.util.concurrent.CompletableFuture;

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

    @Override
    public String sayHello(CallBackListener callBackListener) {
        return null;
    }

    @Override
    public CompletableFuture<String> asyncCall() {
        return null;
    }

    @Override
    public String genericCall(User user) {
        return null;
    }
}
