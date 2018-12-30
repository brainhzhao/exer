package priv.zh.service;

import priv.zh.model.HelloWorld;

public class SpringHelloWorld implements HelloWorld{
    @Override
    public void sayHello(){
        System.out.println("This is SpringHelloWorld!");
    }
}