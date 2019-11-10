package com.zhaohong;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessorHandler implements Runnable {

    private Socket socket;
    private Object service;

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = br.readLine();
            RpcRequest request = JSON.parseObject(str, RpcRequest.class);
            System.out.println("request = " + JSON.toJSONString(request));
            String className = request.getClassName();
            //关键根据接口获取其实现类
            Object o = ConfMonitor.conf.get(className).newInstance();
            Object o1 = MethodUtils.invokeExactMethod(o, request.getMethodName(), request.getParams(), request.getParamsType());
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.println(JSON.toJSONString(o1));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
