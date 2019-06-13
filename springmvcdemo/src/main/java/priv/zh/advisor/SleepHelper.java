package priv.zh.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class SleepHelper implements MethodBeforeAdvice,AfterReturningAdvice{

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable{
         System.out.println("睡觉之前先脱掉衣服...");
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable{
         System.out.println("睡醒了，穿好衣服...");
    }

}