package priv.zh.designpattern.proxy.cglibdynamicproxy;

import net.sf.cglib.proxy.*;

public class CglibProxyIntercepter implements MethodInterceptor{

    @Override
    public Object intercept(Object obj, java.lang.reflect.Method method, Object[] args,MethodProxy proxy) throws Throwable{
        System.out.println("begin proxy method... name is "+method.getName());
        proxy.invokeSuper(obj, args);
        System.out.println("end proxy method... name is "+method.getName());
        return null;
    }
}