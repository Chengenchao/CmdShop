import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {    //psvm
        boolean bool=true;
        while(bool) {

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
            ReadExcel readExcel = new ReadExcel();//创建对象        //斜杠表示的是classpath
            User users[] = readExcel.readExcel(in);
            System.out.println("从excel读取到的密码是：" + users[0].getPassword());


            //System.out.println(users.length);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登陆成功");
                    bool = false;
                    break;
                } else {
                    System.out.println("登录失败");
                }
            /*System.out.print(user.getUsername());
            System.out.println("\t"+user.getPassword());*/
            }
        }

    }

}

