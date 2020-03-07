package threadSingleton;

/**
 * @Author zty
 * @Date 2020/3/7 下午10:09
 * @Description:
 */
public class SingletonTeat {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            Boss.getBoss();
        };

        for (int i = 0;i <100;i++){
            new Thread(runnable).start();
        }

    }
}

/**
 * 懒汉式单例在多线程下会出问题
 */
class Boss{
    private Boss(){
        System.out.println("一个BOSS对象被实例化了");
    }

    private static Boss Instance = null;

    /* 这是一种方法
    public static Boss getBoss(){

        synchronized (""){
            if(Instance == null){
                Instance = new Boss();
            }
        }
        return Instance;
    }
    */

    /**
     * 同步方法 用的类锁
     * @return
     */
    public static synchronized Boss getBoss(){
        if(Instance == null){
            Instance = new Boss();
        }
        return Instance;
    }
}
