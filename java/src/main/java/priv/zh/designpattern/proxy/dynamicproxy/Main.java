package priv.zh.designpattern.proxy.dynamicproxy;

import java.lang.reflect.Proxy;


import net.sf.cglib.proxy.Enhancer;

import  priv.zh.designpattern.proxy.cglibdynamicproxy.CglibProxyIntercepter;
/**
 * @author zhaoheng
 * @version 1.0
 */

 public class Main{
     public static void main(String[] args) throws Throwable{
        //jdk dynamic proxy
        AbstractProxyObject obj= (AbstractProxyObject)Proxy.newProxyInstance(Main.class.getClassLoader(), new Class<?>[]{AbstractProxyObject.class}, new ProxyHandler());
        obj.sayHello();

        //cglib dynamic proxy
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(priv.zh.designpattern.proxy.cglibdynamicproxy.ChineseReal.class);
        enhancer.setCallback(new CglibProxyIntercepter());
        priv.zh.designpattern.proxy.cglibdynamicproxy.AbstractProxyObject cglibObj= (priv.zh.designpattern.proxy.cglibdynamicproxy.AbstractProxyObject)enhancer.create();
        cglibObj.sayHello();
     }
 }