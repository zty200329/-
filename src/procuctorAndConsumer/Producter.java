package procuctorAndConsumer;

/**
 * @Author zty
 * @Date 2020/3/7 下午11:00
 * @Description:
 */
public class Producter extends Thread {

    private  ProductPool pool;

    public Producter(ProductPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true){
            String name = (int)(Math.random()*100)+"号产品";
            System.out.println("生产了一件产品:" + name);
            Product product = new Product(name);
            this.pool.push(product);
        }
    }
}
