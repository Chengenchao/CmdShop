import java.sql.Date;
import java.util.Map;

public class Order {
    /* 该有的属性 依据：数据库 有哪些字段  类就有哪些属性
    订单是哪个客户的？
    订单包含哪些商品
     */
    private User user;
    private Product product[];
    private Map<Integer,Integer> ammount;//数量  无法表达出买了几个哪种商品
    //商品 个数
    //Map结构
    private float totalPay;//总价
    private float actualPay;//实付款
    private Date orderDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product[] getProduct() {
        return product;
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }

    public Map<Integer, Integer> getAmmount() {
        return ammount;
    }

    public void setAmmount(Map<Integer, Integer> ammount) {
        this.ammount = ammount;
    }

    public float getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(float totalPay) {
        this.totalPay = totalPay;
    }

    public float getActualPay() {
        return actualPay;
    }

    public void setActualPay(float actualPay) {
        this.actualPay = actualPay;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}

