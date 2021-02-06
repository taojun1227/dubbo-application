package com.example.dubboprovider.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * <p>Title: com.example.dubboprovider.service.impl.GenericServiceImpl </p>
 *
 * <p>Description:  </p>
 *
 * <p>Company: </p>
 *
 * <p>date: 2021/2/6 14:07 </p>
 *
 * @author: jt-ape
 */
//@Service(interfaceName = "com.example.dubboapi.service.HelloService",version = "generic")
public class GenericServiceImpl implements GenericService {
    @Override
    public Object $invoke(String s, String[] strings, Object[] objects) throws GenericException {
        return "这是一个泛化服务啊哈哈哈";
    }
}
