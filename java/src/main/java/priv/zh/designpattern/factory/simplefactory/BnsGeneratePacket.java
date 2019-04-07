package priv.zh.designpattern.factory.simplefactory;


/**
 * @author zhaoheng
 * @version 1.0
 * 创建大额修改报文
 */


 public class BnsGeneratePacket implements AbstractGeneratePacketI{
     @Override
     public void generatePacket(){
         System.out.println("create bns packet");
     }
 }