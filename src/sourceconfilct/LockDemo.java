package sourceconfilct;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zty
 * @Date 2020/3/7 下午9:07
 * @Description:
 */
public class LockDemo {
    public static void main(String[] args) {

        /**
         * 实例化一个锁对象
         */
        ReentrantLock lock = new ReentrantLock();

        //用四个线程,模拟4个售票员
        Runnable r = () ->{
            while (TicketCenter.restCount > 0){
                //对象锁:
                //类锁
                //需要保证一点:多个线程看到的锁,需要是同一把锁

                //对临界资源上锁
                lock.lock();

                if(TicketCenter.restCount <= 0){
                    return;
                }

                System.out.println(Thread.currentThread().getName() + "卖出一张票,剩余" + --TicketCenter.restCount + "张");

                //对临界资源解锁
                lock.unlock();

            }
        };
        //四个线程,模拟四个售票员
        Thread t1 = new Thread(r,"thread - 1");
        Thread t2 = new Thread(r,"thread - 2");
        Thread t3 = new Thread(r,"thread - 3");
        Thread t4 = new Thread(r,"thread - 4");

        //开启线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
