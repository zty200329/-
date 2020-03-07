package procuctorAndConsumer;

/**
 * @Author zty
 * @Date 2020/3/7 下午10:36
 * @Description:
 */
public class Product {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String name) {
        this.name = name;
    }
}
