package procuctorAndConsumer;

/**
 * @Author zty
 * @Date 2020/3/7 下午11:08
 * @Description:
 */
public class Consumer extends Thread {
    private  ProductPool pool;

    public Consumer(ProductPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true){
            Product product = this.pool.pop();
            System.out.println("消费者消费了一件产品:"+product.getName());
        }
    }
}
