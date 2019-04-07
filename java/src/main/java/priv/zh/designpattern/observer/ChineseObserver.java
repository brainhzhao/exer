package priv.zh.designpattern.observer;


public class ChineseObserver implements Observer{
    @Override
    public void update(int state){
        System.out.println("This is Chinese,Hello. Current State is "+state);
    }
}