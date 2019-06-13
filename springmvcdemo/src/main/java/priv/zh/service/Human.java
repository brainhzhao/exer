package priv.zh.service;

import priv.zh.interfaces.Sleepable;

public class Human implements Sleepable{
    @Override
    public void sleep(){
        System.out.println("begin sleep...");
    }
}