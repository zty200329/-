package thread;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * @Author zty
 * @Date 2020/3/7 下午4:04
 * @Description:
 */
public class ThreadMethod {
    public static void main(String[] args) {

        threadYield();
    }

    /**
     * 线程的礼让
     */
    private static void threadYield(){
        //线程礼让,指的是让当前运行状态的线程释放自己的CPU资源,由运行状态,回到就绪状态.
        //放弃抢到的CPU资源
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    if(i == 3){
                        Thread.yield();
                    }
                }
            }
        };

        Thread thread1 = new Thread(r,"thread-1");
        Thread thread2 = new Thread(r,"thread-2");

        thread1.start();
        thread2.start();
    }

    /**
     * 设置线程的优先级
     */
    private static void threadPriority(){
        //设置线程的优先级.只是修改这个线程可以去抢到CPU时间片的概率
        //并不是优先级高的进程一定能抢到CPU时间片
        //优先级的设置,是一个整数0-10 默认是5
        Runnable t = () ->{
            for (int i =0;i<100;i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        };
        Thread t1 = new Thread(t,"Thread-1");
        Thread t2 = new Thread(t,"Thread-2");

        //设置优先级
        //设置优先级必须要放到线程开始执行(start)之前
        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();

    }

    /**
     * 线程休眠
     */
    private static void threadSleep(){
        //1.实例化一个线程对象
        MyThead2 t = new MyThead2();
        t.start();
    }

    /**
     * 线程命名
     */
    private static void threadName(){
        // 线程的命名
        //1.实例化一个线程对象
        //Thread t = new Thread();
        //t.setName("custom");

        //2.实例化一个线程对象的同时,通过构造方法对线程进行命令
        //Thread(Runable r, String name)
        //Thread t = new Thread(()->{},"custom");
        MyThead2 t = new MyThead2("custom");



        System.out.println(t.getName());
    }
}

class MyThead2 extends Thread{
    public MyThead2(){}
    public MyThead2(String name){
        this.setName(name);
    }

    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            System.out.println(i);
            //线程休眠
            //1.参数:毫秒Wie单位的时间差
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}