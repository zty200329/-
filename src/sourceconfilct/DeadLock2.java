package sourceconfilct;

/**
 * @Author zty
 * @Date 2020/3/7 下午9:33
 * @Description:
 */
public class DeadLock2 {
    public static void main(String[] args) {
        //死锁: 多个线程彼此持有对方所需要的锁对象,而不释放自己的锁.

        //wait: 等待,是Object类中的一个方法,当前线程释放自己的锁标记,并且让出CPU资源.使得当前的线程进入等待队列.
        //notify:通知,是Object类中的一个方法,唤醒等待队列中的一个队列,使这个线程进入锁池.(随机)
        //notifyAll 通知,是Object类中的一个方法,唤醒等待队列中所有的线程,并使这些线程进入锁池
        Runnable runnable1 = () ->{
            synchronized ("A"){
                System.out.println("A线程持有了A锁,等待B锁");

                //释放已经持有的A锁标记,并进入等待队列
                try {
                    "A".wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized ("B"){
                    System.out.println("A线程同时持有了A锁和B锁");
                }
            }
        };

        Runnable runnable2 = () ->{
            synchronized ("B"){
                System.out.println("B线程持有了B锁,等待A锁");

                synchronized ("A"){
                    System.out.println("B线程同时持有了A锁和B锁");
                }
            }
        };
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();

    }
}
