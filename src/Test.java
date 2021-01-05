import java.io.File;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {    //psvm
         /*
        开始读取文件
         */
        File file = new File("D:\\BluePractice\\CmdShop\\src\\user.xlsx");
        ReadExcel readExcel = new ReadExcel();//创建对象
        User users[]=readExcel.readExcel(file);

        System.out.println("请输入用户名：");

        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        //System.out.println("刚刚输入的用户名："+username);

        System.out.println("请输入密码：");
        String password = sc.next();



        //System.out.println(users.length);
        for(User user:users){
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                System.out.println("登陆成功");

            }
            /*System.out.print(user.getUsername());
            System.out.println("\t"+user.getPassword());*/
        }

        }

    }

