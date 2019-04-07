package priv.zh.designpattern.factory.simplefactory;



public class Main{
    public static void main(String[] args) {
        
        AbstractPacketFactoryI generatePacketFactory =new BhGeneratePacketFactory();
        generatePacketFactory.generatePacket("BnhGeneratePacket").generatePacket();
    }
}