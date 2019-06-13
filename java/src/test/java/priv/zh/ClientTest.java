package priv.zh;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * 测试类，模拟客户端发报文
 * @author zhaoheng
 * @version 20190612
 */

public class ClientTest {

    private final static String[] fileNames={"packet/渠道发送报文格式.xml","packet/渠道请求列表报文格式.xml","packet/渠道请求详细报文格式.xml"};
    private InputStream in = null;
    //private PrintWriter pw = null;
    private BufferedReader br = null;
    private Socket socket = null;
    private byte[][] inputFileStreams = null;

    @Before
    public void before(){
        inputFileStreams = new byte[3][];
        for(int i=0;i<=fileNames.length-1;i++){
            try{
                ByteArrayOutputStream buff = new ByteArrayOutputStream();
                byte[] temp = new byte[512];
                in =  getClass().getClassLoader().getResourceAsStream(fileNames[i]);
                int len = 0;
                while ((len=in.read(temp))>0){
                    buff.write(temp,0,len);
                }
                inputFileStreams[i]=buff.toByteArray();
            } catch (IOException ex){
                ex.getStackTrace();
            } finally {
                if(in!=null){
                    try{
                        in.close();
                    }catch (IOException ex){
                        ex.getStackTrace();
                    }
                }
            }
        }
    }

    @Test
    public void client(){
        InputStream inputStream;
        ByteArrayOutputStream buffer;
        int len;
        try{
            for(int i=0;i<=9999;i++){
                byte[] temp = new byte[512];
                buffer = new ByteArrayOutputStream();
                socket = new Socket("127.0.0.1",65533);
                //System.out.println(new String(inputFileStreams[i%3], Charset.forName("utf8")));
                socket.getOutputStream().write(new String(inputFileStreams[i%3], Charset.forName("utf8")).getBytes(),0,inputFileStreams[i%3].length);
                socket.getOutputStream().flush();
                inputStream = socket.getInputStream();
                while ((len=inputStream.read(temp))>=0){
                    buffer.write(temp,0,len);
                }
                System.out.println("发送线程是:"+Thread.currentThread().getName()+","+new String(buffer.toByteArray(),Charset.forName("gbk")));
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            if(in!=null){
                try{
                    in.close();
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            if(socket!=null){
                try{
                    socket.close();
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    @Test
    public void startMutilThread(){
        for(int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    client();
                }
            }).start();
        }
    }
}
