package sourceconfilct;

/**
 * @Author zty
 * @Date 2020/3/7 下午6:53
 * @Description:
 */
public class SourceConfilct {
    //演示临界资源问题
    //某个景点有4个售票员在同时售票
    public static void main(String[] args) {
        //用四个线程,模拟4个售票员
        Runnable r = () ->{
            while (TicketCenter.restCount > 0){
                System.out.println(Thread.currentThread().getName() + "卖出一张票,剩余"+ --TicketCenter.restCount + "张");
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

class TicketCenter{
    //秒速票的数量
    public static int restCount = 100;
}