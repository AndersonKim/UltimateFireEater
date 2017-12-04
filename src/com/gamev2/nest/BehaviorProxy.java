package com.gamev2.nest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * edited by AndersonKim
 * at 2017/11/29
 */
public class BehaviorProxy implements InvocationHandler {
    Object proxyObj;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result=method.invoke(proxyObj,args);
        System.out.println("after");
        return result;
    }
}
