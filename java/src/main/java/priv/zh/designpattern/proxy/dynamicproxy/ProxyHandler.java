package priv.zh.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class ProxyHandler implements InvocationHandler{

    private ChineseReal real;

    public ProxyHandler(){
        real=new ChineseReal();
    }

    @Override
    public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
        System.out.println("invoke proxy method...,name is "+method.getName());
        real.sayHello();
        System.out.println("invoke proxy method end ..."); 
        return null;  
    }
}