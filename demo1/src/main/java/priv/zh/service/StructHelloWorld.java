package priv.zh.service;

import priv.zh.model.HelloWorld;

public class StructHelloWorld implements HelloWorld{
    @Override
    public void sayHello(){
        System.out.println("This is StructHelloWorld!");
    }

}