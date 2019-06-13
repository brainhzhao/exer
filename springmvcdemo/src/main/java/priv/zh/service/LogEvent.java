package priv.zh.service;

import org.springframework.context.ApplicationEvent;

public class LogEvent extends ApplicationEvent{
    
    private final static long serialVersionUID =1l;

    public LogEvent(Object obj){
        super(obj);
        System.out.println("Log Event publisher");
    }
}