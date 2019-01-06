package priv.zh.thread;


import java.lang.ThreadLocal;
import java.lang.Runnable;

/*
  @author zhaoheng
  @propose exer 
*/

//ThreadLocal 可以实现线程的私有变量

public class ThreadLocalDemo{

    //实例化一个线程私有变量的对象生成器,测试一波
    private ThreadLocal<Integer> seqNum=new ThreadLocal<Integer>(){
        @Override
        public Integer initialValue(){
            return 0; 
        }
    };
    
    public void start(){
        Thread thread1=new Thread(new ThreadDemo(seqNum));
        Thread thread2=new Thread(new ThreadDemo(seqNum));
        Thread thread3=new Thread(new ThreadDemo(seqNum));

        thread1.start();
        thread2.start();
        thread3.start();

    }


    private static class ThreadDemo implements Runnable{
        private ThreadLocal<Integer> seq;

        public ThreadDemo(ThreadLocal<Integer> seq){
            this.seq=seq;
        }
        @Override 
        public void run(){
            for(int i=0;i<=5;i++){
                System.out.printf("Current Thread is %s,seq is [%d]\n",Thread.currentThread().getName(),seq.get());
                seq.set(seq.get()+1);
            }
        }
    }

}