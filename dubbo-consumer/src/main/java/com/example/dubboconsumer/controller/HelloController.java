package com.example.dubboconsumer.controller;

import com.example.dubboapi.listener.CallBackListener;
import com.example.dubboapi.model.User;
import com.example.dubboapi.service.HelloService;
import com.example.dubboconsumer.callback.CallBackListenerImpl;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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
//    @Reference(interfaceName = "com.example.dubboapi.service.HelloService",generic = true)
    private GenericService genericService;
//    @Reference
    private HelloService helloService;

    @Reference(version = "generic")
    private HelloService genericHelloService;

    @RequestMapping("/say")
    public String say() {

        CompletableFuture<String> completableFuture = RpcContext.getContext().asyncCall(() -> {
            return helloService.sayHello("异步调用");
        });

        String result = helloService.sayHello("hahahaha");
        System.out.println(result);

        try {
            String s = completableFuture.get();
            System.out.println("异步返回结果："+s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
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
    @RequestMapping("/sync")
    public String say3() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = helloService.asyncCall();

        // 添加回调
        stringCompletableFuture.whenComplete((result, exception) -> {
           if (exception == null) {
               System.out.println("异步返回结果："+result);
           }
        });
        System.out.println("输出一段话，打印再异步返回结果前面");
        return "success";
    }

    @RequestMapping("/generic")
    public String say4() {

        Map<String,Object> user = new HashMap<String,Object>();
        user.put("class", "com.example.dubboapi.model.User");
        user.put("name","泛化用户");
        user.put("age", "23");

        return genericService.$invoke("genericCall", new String[] {"com.example.dubboapi.model.User"}, new Object[]{user}).toString();
    }

    @RequestMapping("/genericService")
    public String say5() {
        return genericHelloService.sayHello("11111");
    }

}
