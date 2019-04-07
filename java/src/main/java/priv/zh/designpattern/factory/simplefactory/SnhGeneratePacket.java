package priv.zh.designpattern.factory.simplefactory;


public class SnhGeneratePacket implements AbstractGeneratePacketI{
    @Override
    public void generatePacket(){
        System.out.println("create snh packet...");
    }
}