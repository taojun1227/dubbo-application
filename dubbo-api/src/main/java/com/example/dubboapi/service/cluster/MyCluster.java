package com.example.dubboapi.service.cluster;

import org.apache.dubbo.rpc.*;
import org.apache.dubbo.rpc.cluster.Cluster;
import org.apache.dubbo.rpc.cluster.Directory;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.apache.dubbo.rpc.cluster.support.AbstractClusterInvoker;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: com.example.dubboprovider.cluster.MyCluster </p>
 *
 * <p>Description:  </p>
 *
 * <p>Company: </p>
 *
 * <p>date: 2021/2/2 22:59 </p>
 *
 * @author: jt-ape
 */
public class MyCluster implements Cluster {
    @Override
    public <T> Invoker<T> join(Directory<T> directory) throws RpcException {
        return new AbstractClusterInvoker<T>(directory) {
            @Override
            protected Result doInvoke(Invocation invocation, List<Invoker<T>> invokers, LoadBalance loadBalance) throws RpcException {

                List<Invoker<T>> copyInvokers = invokers;
                // 检查服务列表
                this.checkInvokers(invokers, invocation);

                List<Invoker<T>> invoked = new ArrayList<Invoker<T>>(copyInvokers.size());
                Result result = null;
                // 通过负载均衡策略选择一个服务
                Invoker<T> invoker = this.select(loadBalance, invocation, copyInvokers, invoked);

                // 自定义容错方案，
                for (int i=0;i<5;i++) {
                        result = invoker.invoke(invocation);
                        if (result.hasException()) {
//                            result = new AsyncRpcResult();
//                            result.setValue(invoker.getUrl().getPort()+"：大哥我尽力了，尝试了五次都失败了");
                        }
                }


                return result;
            }
        };
    }
}
