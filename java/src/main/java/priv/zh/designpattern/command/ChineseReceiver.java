package priv.zh.designpattern.command;

public class ChineseReceiver implements CommandReceiver{
    @Override
    public void sayHello(){
        System.out.println("我是中国人");
    }

    @Override
    public void sayWhereFrom(){
        System.out.println("我来自神州数码");
    }
}
