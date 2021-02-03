package com.example.dubboprovider.service.impl;

import com.example.dubboapi.model.User;
import com.example.dubboapi.service.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.remoting.RemotingException;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;

/**
 * <p>Title: com.example.dubboprovider.service.impl.HelloServiceImpl </p>
 *
 * <p>Description:  </p>
 *
 * <p>Company: </p>
 *
 * <p>date: 2021/2/1 12:43 </p>
 *
 * @author: jt-ape
 */
@Service(loadbalance = "roundrobin",timeout = 7000)
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int port =RpcContext.getContext().getUrl().getPort();
        System.out.println("11111111111111111111111111111111111");
//        throw new RuntimeException("测试集群容错。。。");
//        throw new RpcException("我看看这个异常");
        return "["+ port + "]" + "dubbo say hello："+ name;
    }

    @Override
    public User sayHello()  {
        System.out.println("22222222222222222222");
//        return new User("jack", "12");
        throw new RpcException("我看看这个异常一定要抛出这个异常RemotingException");
    }
}
