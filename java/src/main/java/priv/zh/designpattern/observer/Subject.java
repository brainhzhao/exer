package priv.zh.designpattern.observer;

import java.util.List;
import java.util.ArrayList;

public class Subject{
    //存放观察者
    private List<Observer> observers= new ArrayList<>();
    private int state;

    public void changeState(int state){
        this.state=state;
        notifyAllObserver();
    }

    //添加观察者
    public void attach(Observer observer){
        this.observers.add(observer);
    }

    //通知所有观察者
    public void notifyAllObserver(){
        for(Observer ob : this.observers){
            ob.update(state);
        }
    }

}