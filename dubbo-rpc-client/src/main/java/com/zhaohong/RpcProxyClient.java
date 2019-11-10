package com.zhaohong;

import java.lang.reflect.Proxy;

public class RpcProxyClient {

    /**
     * 动态代理
     *
     * @param interfaceCls
     * @param host
     * @param port
     * @param <T>
     * @return
     */
    public <T> T clientProxy(final Class<T> interfaceCls, final String host, final int port) {
        T res = (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class[]{interfaceCls},
                new WeatherInvokHanler(host, port));
        return res;
    }
}
