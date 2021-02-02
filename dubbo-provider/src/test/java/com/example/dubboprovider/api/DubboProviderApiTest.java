package com.example.dubboprovider.api;

import com.example.dubboapi.service.HelloService;
import com.example.dubboprovider.service.impl.HelloServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * <p>Title: com.example.dubboprovider.api.DubboProviderApiTest </p>
 *
 * <p>Description:  </p>
 *
 * <p>Company: </p>
 *
 * <p>date: 2021/2/1 21:14 </p>
 *
 * @author: jt-ape
 */

public class DubboProviderApiTest {
    @Test
    public void test() throws IOException {
        // 创建应用
        ApplicationConfig applicationConfig = new ApplicationConfig("provider");
        // 创建协议
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        // port 设置为-1表示随机端口
        protocolConfig.setPort(20880);
        // 创建注册中心
        RegistryConfig registryConfig = new RegistryConfig();
        /**
         * 注册中心方式
         */
//        registryConfig.setAddress("121.36.168.192:2181,121.36.168.192:2182,121.36.168.192:2183");
//        registryConfig.setProtocol("zookeeper");
        /**
         * 广播方式
         */
        registryConfig.setAddress("multicast://224.1.2.3:1009");
        // 注册服务
        ServiceConfig<HelloService> serviceServiceConfig = new ServiceConfig<>();
        serviceServiceConfig.setApplication(applicationConfig);
        serviceServiceConfig.setProtocol(protocolConfig);
        serviceServiceConfig.setRegistry(registryConfig);
        serviceServiceConfig.setInterface(HelloService.class);
        serviceServiceConfig.setRef(new HelloServiceImpl());
        // 暴露服务
        serviceServiceConfig.export();
        System.in.read();
    }

}
