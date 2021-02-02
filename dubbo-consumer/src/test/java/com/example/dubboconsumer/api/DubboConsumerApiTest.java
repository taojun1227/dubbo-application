package com.example.dubboconsumer.api;

import com.example.dubboapi.service.HelloService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * <p>Title: com.example.dubboconsumer.api.DubboConsumerApiTest </p>
 *
 * <p>Description:  </p>
 *
 * <p>Company: </p>
 *
 * <p>date: 2021/2/1 21:34 </p>
 *
 * @author: jt-ape
 */
public class DubboConsumerApiTest {

    @Test
    public void test() throws IOException {
        // 创建应用
        ApplicationConfig applicationConfig = new ApplicationConfig("consumer");
        // 创建注册中心
        RegistryConfig registryConfig = new RegistryConfig();
        /**
         *  注册中心方式
         */
        // zookeeper集群
//        registryConfig.setAddress("121.36.168.192:2181,121.36.168.192:2182,121.36.168.192:2183");
//        registryConfig.setProtocol("zookeeper");
        /**
         * 广播方式
         */
        registryConfig.setAddress("multicast://224.1.2.3:1009");
        ReferenceConfig<HelloService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(HelloService.class);
//        referenceConfig.setCheck(false);
        HelloService helloService = referenceConfig.get();
        System.out.println(helloService.sayHello("dubbo api"));

    }
}
