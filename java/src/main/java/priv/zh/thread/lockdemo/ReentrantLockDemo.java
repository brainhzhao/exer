package priv.zh.thread.lockdemo;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.lang.InterruptedException;
/*

@author zhaoheng
目的：
学习一下显式锁
 Lock 接口提供了无条件的、可轮询的、定时的、可中断的锁获取操作，所有加锁、解锁方式都是显式的
 Lock包位于 java.lang.concurrent.locks.Lock中
 其核心方法是 lock()、unlock()、tryLock()
     实现类有ReentrantLock、ReentrantReadWriteLock.ReadLock、ReentrantReadWrite.Writelock
*/
public class ReentrantLockDemo {
    public static void main(String[] args){
          new ReentrantLockDemo().exec();
    }

    public void exec(){
        final Count ct=new Count();
        for (int i=0;i<2;i++){
            new Thread(()->{ct.get();}).start();
        }

        for (int i=0;i<2;i++){
            new Thread(()->{ct.put();}).start();
        }
    }

    public class Count{
        final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
        public void get(){
            
            try {
                //add lock
                lock.readLock().lock();
                System.out.println("Current Thread is "+Thread.currentThread().getName()+" get begin");
                Thread.sleep(1000L);
                System.out.println("Current Thread is "+Thread.currentThread().getName()+" get end");
                lock.readLock().unlock();
                //drop lock
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }
        public void put(){
            try {
                lock.writeLock().lock();
                System.out.println("Current Thread is "+Thread.currentThread().getName()+" put begin");
                Thread.sleep(1000L);
                System.out.println("Current Thread is "+Thread.currentThread().getName()+" put end");
                lock.writeLock().unlock();
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
} 