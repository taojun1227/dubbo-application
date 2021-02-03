package com.example.dubboapi.service;

import com.example.dubboapi.listener.CallBackListener;
import com.example.dubboapi.model.User;

/**
 * <p>Title: com.example.dubboapi.service.HelloService </p>
 *
 * <p>Description:  </p>
 *
 * <p>Company: </p>
 *
 * <p>date: 2021/2/1 12:31 </p>
 *
 * @author: jt-ape
 */
public interface HelloService {
    /**
     * 返回一句话
     * @param name
     * @return: java.lang.String
     * @Author: jt-ape
     * @Date: 2021/2/1 12:32
     */
    public String sayHello(String name);

    public User sayHello();

    public String sayHello(CallBackListener callBackListener);
}
