package priv.zh.thread.syndemo;

import java.text.SimpleDateFormat;


public class SynChronizedDemo{
    private static int num=0;

    public static synchronized  void add(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("occur interrupt exception");
        }
        num++;
        System.out.println("Current Thread is "+Thread.currentThread().getName()+",num is "+num);
    }
    
    public static void main(String[] args) {
        

        Thread thread1=new Thread(new ThreadImple(),"thread01");
        Thread thread2=new Thread(new ThreadImple(),"thread02");
        Thread thread3=new Thread(new ThreadImple(),"thread03");
        Thread thread4=new Thread(new ThreadImple(),"thread04");
        Thread thread5=new Thread(new ThreadImple(),"thread05");
        Thread daemonThread=new Thread(){
            private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            @Override
            public void run(){
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                    System.out.println("This is daemonThread,current timestamp is "+dateFormat.format(System.currentTimeMillis()));
                }
            }
        };
        daemonThread.setDaemon(true);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        daemonThread.start();

    }

    private static class ThreadImple implements Runnable{
        
        @Override
        public void run(){

            try {
                if(Thread.currentThread().getName().equals("thread01") || Thread.currentThread().getName().equals("thread05"))
                   Thread.sleep(5000);
                SynChronizedDemo.add();
            } catch (Exception e) {
                
            }
        }
    }
}