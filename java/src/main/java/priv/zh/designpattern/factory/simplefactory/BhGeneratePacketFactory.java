package priv.zh.designpattern.factory.simplefactory;

/**
 * @author zhaoheng
 * @version 1.0
 * 报文创建工程
 */


 public class BhGeneratePacketFactory implements AbstractPacketFactoryI{
    

    public AbstractGeneratePacketI generatePacket(String packetType){
        try{
            return (AbstractGeneratePacketI)getClass().getClassLoader().loadClass(PREFIXPACKAGE_STRING+packetType).newInstance();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    } 
 }