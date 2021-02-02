package com.example.dubboprovider.service.impl;

import com.example.dubboapi.service.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

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
        return "["+ port + "]" + "dubbo say hello："+ name;
    }
}
