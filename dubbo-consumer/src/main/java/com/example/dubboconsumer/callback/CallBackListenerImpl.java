package com.example.dubboconsumer.callback;

import com.example.dubboapi.listener.CallBackListener;

import java.io.Serializable;

/**
 * <p>Title: com.example.dubboconsumer.callback.CallBackListenerImpl </p>
 *
 * <p>Description:  </p>
 *
 * <p>Company: </p>
 *
 * <p>date: 2021/2/4 0:11 </p>
 *
 * @author: jt-ape
 */
public class CallBackListenerImpl implements CallBackListener {
    @Override
    public String callBack() {
      return "这是客户端回调返回的东西";
    }
}
