package priv.zh.thread.syndemo;


/*
*   deadlock demo
*   @author zhaoheng
*/
public class DeadlockDemo{

    private class Count implements Runnable{
        // define a monitor object1
        private byte[] lock1=new byte[1];
        // define a monitor object2
        private byte[] lock2=new byte[2];
        @SuppressWarnings({"unused"})
        // define a private variable
        private int num=0;

        public void add(){
            String currentThreadName=Thread.currentThread().getName();
            if(currentThreadName.equals("Thread01")){
                // if current thread named "THread01",add lock on lock1,else lock2
                synchronized(lock1){
                    System.out.println("Thread01 start!");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        System.out.println("interrupt exception!");
                    }
                    synchronized(lock2){
                        this.num++;
                    }
                    System.out.println("Thread01 end!");
                }
            }
            else if(currentThreadName.equals("Thread02")){
                System.out.println("Thread02 start!");
                synchronized(lock2){
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        System.out.println("interrupt exception!");
                    }
                    synchronized(lock1){
                        this.num++;
                    }
                }
                System.out.println("Thread02 end!");

            }
        }
        @Override
        public void run(){
           add();
        }
    }
   

    public static void main(String[] args) {
        Count execThread=(new DeadlockDemo()).new Count();
        Thread thread01=new Thread(execThread,"Thread01");
        Thread thread02=new Thread(execThread,"Thread02");
        thread01.start();
        thread02.start();
    }
}