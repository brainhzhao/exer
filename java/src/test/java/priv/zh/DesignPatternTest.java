package priv.zh;

import org.junit.Test;

import priv.zh.designpattern.command.*;
import priv.zh.designpattern.observer.AmericanObserver;
import priv.zh.designpattern.observer.ChineseObserver;
import priv.zh.designpattern.observer.RussianObserver;
import priv.zh.designpattern.observer.Subject;

import static priv.zh.designpattern.command.Invoker.*;

/**
 * @author zhaoheng
 * @version 1.0
 * 设计模式测试类
 */
public class DesignPatternTest{

    /**
     * @author zhaoheng
     * 观察者模式测试方法
     */
    @Test
    public void observerPattern(){
        //define subject
        Subject subject=new Subject();
        //define observer
        ChineseObserver chineseObserver=new ChineseObserver();
        RussianObserver russianObserver=new RussianObserver();
        AmericanObserver americanObserver=new AmericanObserver();
        //attach observer
        subject.attach(chineseObserver);
        subject.attach(russianObserver);
        subject.attach(americanObserver);
        
        subject.changeState(1);
        for(int i=0;i<10;i++){
            try {
                subject.changeState(i+1);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @author zhaoheng
     * 命令模式
     */
    @Test
    public void commandPattern() throws Exception{
        CommandReceiver receiver = (CommandReceiver) Class.forName("priv.zh.designpattern.command.JapaneseReceiver").newInstance();
        Command command = (Command)Class.forName("priv.zh.designpattern.command.CommandChinese").newInstance();
        execute(command,receiver);

    }
}