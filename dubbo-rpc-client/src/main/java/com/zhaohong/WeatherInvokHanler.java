package com.zhaohong;


import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInvokHanler implements InvocationHandler {
    private String host;
    private int port;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest request = new RpcRequest();
        request.setMethodName(method.getName());
        request.setClassName(method.getDeclaringClass().getName());
        request.setParams(args);
        request.setParamsType(method.getParameterTypes());
        Socket socket = new Socket(this.host, this.port);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("开始发送request-->" + JSON.toJSONString(request));
        pw.println(JSON.toJSONString(request));
        System.out.println("=======================================");
        String resp = br.readLine();
        System.out.println("------------------------------------");
        System.out.println("resp -- > " + resp);
        socket.close();
        return JSON.parseObject(resp, method.getReturnType());
    }
}
