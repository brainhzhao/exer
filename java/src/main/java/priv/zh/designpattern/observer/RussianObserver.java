package priv.zh.designpattern.observer;


public class RussianObserver implements Observer{
    @Override
    public void update(int state){
        System.out.println("This is Russian,Hello. Current State is "+state);
    }
}