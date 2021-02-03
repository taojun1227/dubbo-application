package com.example.dubboapi.service;

import com.example.dubboapi.service.HelloService;

/**
 * <p>Title: com.example.dubboconsumer.stub.DemoStub </p>
 *
 * <p>Description:  </p>
 *
 * <p>Company: </p>
 *
 * <p>date: 2021/2/3 1:11 </p>
 *
 * @author: jt-ape
 */
public class HelloServiceStub implements HelloService{
    private HelloService helloService;
    public HelloServiceStub(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name){
        System.out.println("提供者调用服务之前执行....");
        return helloService.sayHello(name);
    }

}
