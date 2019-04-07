package priv.zh.designpattern.factory.simplefactory;


/**
 * @author zhaoheng
 * @version 1.0
 * 抽象工厂模式
 */

 public interface AbstractPacketFactoryI{
    String PREFIXPACKAGE_STRING="priv.zh.designpattern.factory.simplefactory.";
    AbstractGeneratePacketI generatePacket(String packetType); 
 }