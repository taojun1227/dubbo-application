package com.example.dubboprovider.service.impl;

import com.example.dubboapi.listener.CallBackListener;
import com.example.dubboapi.model.User;
import com.example.dubboapi.service.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

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

    private final Map<String, CallBackListener> listeners = new ConcurrentHashMap<String, CallBackListener>();

    @Override
    public String sayHello(@QueryParam("name") String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int port =RpcContext.getContext().getUrl().getPort();
        System.out.println("11111111111111111111111111111111111");
//        throw new RuntimeException("测试集群容错。。。");
        throw new RpcException("我看看这个异常");
//        return "["+ port + "]" + "dubbo say hello："+ name;
    }

    @Override
    public User sayHello()  {
        System.out.println("22222222222222222222");
//        return new User("jack", "12");
        throw new RpcException("我看看这个异常一定要抛出这个异常RemotingException");
    }

    @Override
    public String sayHello(CallBackListener callBackListener) {
        return callBackListener.callBack();
    }

    @Override
    public CompletableFuture<String> asyncCall() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "我是一个异步方法";
        });
    }

    @Override
    public String genericCall(User user) {
        System.out.println(user);
        return "泛化返回成，接收到的用户名："+user.getName();
    }
}
