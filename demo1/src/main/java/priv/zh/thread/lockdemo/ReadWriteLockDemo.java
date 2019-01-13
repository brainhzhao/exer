package priv.zh.thread.lockdemo;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

/*author SilenceZhao
* 练习一波ReadWriteLock
* ReadWriteLock 是一个接口，提供了readLock和writeLock两种锁的操作机制，
* 也就是一个资源能够被多个读线程，或者被一个写线程访问，或者被一个写线程访问 
*/


public class ReadWriteLockDemo{
    
    // define a ReadWriteLock object
    private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    
    @SuppressWarnings({"unused"})
    // get read lock
    private Lock readLock=readWriteLock.readLock();
    
    @SuppressWarnings({"unused"})
    //get write lock
    private Lock writeLock=readWriteLock.writeLock();

    
    public static void main(String[] args) {
        new ReadWriteLockDemo().exec();
    }

    public void exec(){
         ReentrantLockDemo.Count ct=new ReentrantLockDemo().new Count();
         for (int i=0;i<2;i++){
            new Thread(){
                public void run(){
                    ct.get();
                }
            }.start();
        }

        for (int i=0;i<2;i++){
            new Thread(){
                public void run(){
                    ct.put();
                }
            }.start();
        }
    }
}