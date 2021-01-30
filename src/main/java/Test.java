import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    static Product carts[] = new Product[3];//创建购物车（用数组模拟）
    static int count = 0;

    public static void main(String[] args) throws ClassNotFoundException {    //psvm
        boolean bool = true;
        while (bool) {

            System.out.println("请输入用户名：");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();//阻塞方法
            //System.out.println("刚刚输入的用户名："+username);
            //System.out.println("你输入的用户名"+username);

            System.out.println("请输入密码：");
            String password = sc.next();
            //System.out.println("你输入的密码是：");

         /*
        开始读取文件
         */
            //File file = new File("D:\\BluePractice\\CmdShop\\src\\user.xlsx");
            InputStream in = Class.forName("Test").getResourceAsStream("/user.xlsx");//输入流的方式，不要把路径写死

            //InputStream inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//输入流的方式，不要把路径写死

            ReadUserExcel readExcel = new ReadUserExcel();//创建对象        //斜杠表示的是classpath
            User users[] = readExcel.readExcel(in);
            System.out.println("从excel读取到的密码是：" + users[0].getPassword());


            //System.out.println(users.length);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword().trim())) {
                    bool = false;
                    System.out.println("登陆成功");
                    /*登陆成功后显示商品信息*/
                    //shopping(sc);

                    while (true) {
                        System.out.println("查看购物车请按1");
                        System.out.println("购物请按2");
                        System.out.println("结账请按3");
                        System.out.println("退出请按0");
                        int choose = sc.nextInt();

                        if (choose == 1) {
                            viewCarts();
                        }
                        /*for(int j=0;j<carts.length;j++){
                            if(carts[j]!=null) {
                                System.out.print(carts[j].getId());
                                System.out.print("\t" + carts[j].getName());
                                System.out.print("\t" + carts[j].getPrice());
                                System.out.println("\t\t" + carts[j].getDesc());
                            }
                        }*/
                         else if (choose == 2) {
                            shopping(sc);//
                        /*readProductExcel = new ReadProductExcel();
                        inPro=null;
                        inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//输入流的方式，不要把路径写死
                        products= readProductExcel.getAllProduct(inPro);
                        for(Product p:products){
                            System.out.print(p.getId());
                            System.out.print("\t"+p.getName());
                            System.out.print("\t"+p.getPrice());
                            System.out.println("\t"+p.getDesc());
                        }*/
                            /*遍历数组*/
                        /*System.out.println("请输入商品的ID，把该商品加入购物车");
                        pId=sc.next();
                        readProductExcel1 = new ReadProductExcel();
                        inPro=null;
                        inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//输入流的方式，不要把路径写死
                        Product product1= readProductExcel1.getProductById(pId,inPro);
                        if(product!=null){
                            //System.out.println("找到了该商品");
                            /*把商品加入购物车 */
                            /*carts[count++]=product1;
                        }*/
                        } else if(choose==3){
                             /*(1）产生订单 （订单类）
                             （2）用POI创建Order.xlsx文件
                             （3）把购物车里的商品写入Order.xlsx文件*/
                             Order order = new Order();
                             order.setUser(users[i]);//谁登陆就是那个用户  订单关联用户
                            // order.setProducts(carts);
                            Product products[] =new Product[count];
                            int num=0;

                            /*实际买了2个商品，怎样把carts中的2个Product对象放入products数组*/
                            for(int j=0;j<carts.length;j++){
                                if(carts[j]!=null){
                                    //num++;
                                    products[j]=carts[j];
                                }
                            }
                            //如何关联订单和商品
                            order.setProduct(products);//实际买了2个商品，购物车中存了两个商品

                            /*下订单*/
                            Map<Integer,Integer> ammount =new HashMap<Integer, Integer>();
                            ammount.put(1111,2);
                            ammount.put(2222,1);

                            order.setAmmount(ammount);

                            CreateOrder.createOrder(order);

                        }else if (choose == 0) {
                             //System.exit(0);
                            break;
                        }
                     /*
                    1、查看购物车
                        （1）购物车是用数组模拟的
                        （2）就是把数组内的元素一个一个找出来：对数组遍历
                    2、继续购物
                      （1）显示所有商品
                      （2）
                     */
                    }
                    break;

                } else {
                    System.out.println("登录失败");
                }
            /*System.out.print(user.getUsername());
            System.out.println("\t"+user.getPassword());*/
            }
        }

    }

    public static void viewCarts() {
        for (Product product : carts) {
            if (product != null) {
                System.out.print(product.getId());
                System.out.print("\t" + product.getName());
                System.out.print("\t" + product.getPrice());
                System.out.println("\t\t" + product.getDesc());
            }
        }
    }

    public static void shopping(Scanner sc) throws ClassNotFoundException {
        InputStream inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//输入流的方式，不要把路径写死
        ReadProductExcel readProductExcel = new ReadProductExcel();
        Product products[] = readProductExcel.getAllProduct(inPro);
        for (Product product : products) {
            System.out.print(product.getId());
            System.out.print("\t" + product.getName());
            System.out.print("\t" + product.getPrice());
            System.out.println("\t\t" + product.getDesc());
        }
        /*遍历数组*/
        System.out.println("请输入商品的ID，把该商品加入购物车");
        String pId = sc.next();//加入商品数量
        ReadProductExcel readProductExcel1 = new ReadProductExcel();
        inPro = null;
        inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//输入流的方式，不要把路径写死
        Product product = readProductExcel1.getProductById(pId, inPro);
        if (product != null) {
            //System.out.println("找到了该商品");
            /*把商品加入购物车 */
            carts[count++] = product;
        }

    }

}

