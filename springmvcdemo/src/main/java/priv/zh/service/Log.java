package priv.zh.service;

import org.springframework.context.ApplicationListener;

public class Log implements ApplicationListener<LogEvent>{
    @Override
    public void onApplicationEvent(LogEvent e){
        System.out.println(e.toString());
        System.out.println("消息接受完毕");
    }
}