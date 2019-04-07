package priv.zh.designpattern.factory.simplefactory;


/**
 * @author zhaoheng
 * @version 1.0
 * 创建可疑修改报文
 */


 public class SnsGeneratePacket implements AbstractGeneratePacketI{
     @Override
     public void generatePacket(){
         System.out.println("create sns packet ...");
     }
 }