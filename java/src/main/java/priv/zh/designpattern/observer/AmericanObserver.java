package priv.zh.designpattern.observer;


public class AmericanObserver implements Observer{
    @Override
    public void update(int state){
        System.out.println("This is American,Hello. Current State is "+state);
    }
}