package thread;

/**
 * @Author zty
 * @Date 2020/3/7 下午3:43
 * @Description:
 */
public class ThreadCreate {
    public static void main(String[] args) {
        //线程实例化
        //1.继承Thread类,做一个线程子类(自定义线程类)
        MyThread mt = new MyThread();

        //注意:
        //需要调用start方法,使线程启动.
        //start方法会开启一个新的线程,来执行run中的逻辑
        //如果直接调用run方法,则线程mt不会进入就绪态
        mt.start();

        Runnable r1 = () ->{
            for (int i = 0;i < 10;i++){
                System.out.println("线程2中的逻辑:"+i);
            }
        };
        Thread t2 = new Thread(r1);
        t2.start();

        System.out.println("主线程中的逻辑执行结束了");
    }
}

/**
 * 这是一个自定义的线程类
 */
class MyThread extends Thread{

    /**
     * 需要重写run方法
     * 将需要并发执行的任务写到run方法中
     */
    @Override
    public void run() {
        for(int i = 0;i < 10;i++){
            System.out.println("子线程中的逻辑" + i);
        }
    }
}