package priv.zh.designpattern.factory.simplefactory;


public class BsGeneratePacketFactory implements AbstractPacketFactoryI{
    @Override
    public AbstractGeneratePacketI generatePacket(String packetType){
        try{
            return (AbstractGeneratePacketI)getClass().getClassLoader().loadClass(PREFIXPACKAGE_STRING+packetType).newInstance();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}