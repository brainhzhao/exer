package priv.zh.designpattern.factory.simplefactory;


/**
 * @author zhaoheng
 * @version 1.0
 * 生产大额新增报文类
 */


public class BnhGeneratePacket implements AbstractGeneratePacketI{

    @Override
    public void generatePacket(){
        System.out.println("create bnh packet");
    }
}