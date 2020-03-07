package sourceconfilct;

/**
 * @Author zty
 * @Date 2020/3/7 下午8:34
 * @Description:
 */
public class SynchronizedFunction {
    //某个景点有4个售票员在同时售票
    public static void main(String[] args) {
        //同步方法:用关键字synchronized修饰的方法就是同步方法
        //用四个线程,模拟4个售票员
        Runnable r = () ->{
            while (TicketCenter.restCount > 0){
                //对象锁:
                //类锁
                //需要保证一点:多个线程看到的锁,需要是同一把锁
                    soldTicket();
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

    /**
     * 同步的方法
     * 静态方法:同步锁就是 类锁 当前类.class
     * 非静态方法:同步锁就是 this
     */
    private synchronized static void soldTicket(){
        if(TicketCenter.restCount <=0) {
            return;
        }
        System.out.println(Thread.currentThread().getName() + "卖出一张票,剩余" + --TicketCenter.restCount + "张");
    }
}
