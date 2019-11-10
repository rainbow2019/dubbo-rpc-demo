package com.zhaohong;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RpcRequest {
    private String className;
    private String methodName;
    private Object[] params;
    private Class[] paramsType;
}
