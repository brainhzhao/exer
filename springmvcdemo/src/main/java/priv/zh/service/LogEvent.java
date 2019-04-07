package priv.zh.service;

import org.springframework.context.ApplicationEvent;

public class LogEvent extends ApplicationEvent{
    
    public LogEvent(Object obj){
        super(obj);
        System.out.println("Log Event publisher");
    }
}