# 项目目的
- 如何进行实体类的抽取
- 如何创建对象 //类名 对象名字 = new 类名（）；
- 如何给对象赋值
- 类之间的关系（终极目标）：如果搞不清类之间的关系，那么将来创建数据库表的时候就会懵圈

-  关系：依赖 关联 包含 
- 对象.方法  [方法调用]
- classpath 含义：类的路径 如：Java中 jar包-class  path  

- 控制台输入 Scanner  包java.util.Scanner
- 数据类型 两大类： 基本数据类型和引用数据类型
        引用类型：类；接口；数组
- 判断字符串中是否包含我们期望的字符：indexOf contain()
- 方法传参数的方式：按值传递和按引用传递 --字符串按值传递
- 封装的步骤：先设private 再 set get
- 方法结束的标志：return 无返回值也是return 写不写都得
- 成员变量：在类中定义的变量  局部变量：在方法中进行定义的变量
- Java哪个命令编译程序：javac.
- 方法概念：为了实现某个功能的操作//能完成特定功能的代码的集合 如：求一个绝对值 abs函数
        模块化编程

## 一、登录实现

- cmd中运行程序，提示输入用户的id和密码
- 把输入的id和密码与customer.xml中的进行比对
- 如果正确，则提示登录成功，并显示当前有哪些商品可以购买

## 二、添加商品到购物车

- 根据商品ID，可以把商品加入购物车

## 三、下订单

- 查看购物车，可以下订单
- 下订单的时候需要生成一个新的excel（order.xlsx：里面存储了客户的id、客户的姓名、客户的电话、客户的地址、订单金额、商品名称）

## 四、要求

- 采用面向对象的思想去实现，根据需求，自己去设计相应的类





## 五、 github 上传Cmdshop project
- settings -> Developer settings ->Personal access token
token 是身份标识
    Token [c542c0f9e89dee41de7e90a2c16ac4e8a0d90a06]
          [4b0011fab100a5744c05ad447bfb9026066671f0]
1. IDEA 中Files->Settings->Version control->Github-> + ->Enter Token ->粘贴入Token码
2. 点击 VCS->import Version control->Share project on Github

## 六、创建users.xlsx
 "请输入用户名：".sout回车---System.out.println("请输入用户名：");
 
 ## 七、接受键盘输入
 ```java
 Scanner sc = new Scanner(System.in)
 String username =sc.next();//把键盘输入的东西给username

```
## 八、读取excel
java 用POI读取excel     ALT+INSERT  给所有的属性增加SETTER和GETTER  [成员方法]
桌面的excel要复制进去 程序
- ALT+INSERT  给所有的属性增加SETTER和GETTER                  


## 九、项目技术栈
- 类
- 对象
- 数组
- 流程控制
- POI(读取Excel)
- 接受键盘输入（Scanner）
- 字符串的比较（equals）
- 增强for循环
- 文件路径

## 十、github的开发模式
- master创建分支；每个项目组成成员从master创建一个自己的分支，每天下班前，测试完毕没有问题的情况下再合并到master中
- 项目组成的成员fork，每天下班前测试完毕没有问题的情况下，然后给创建仓库的人（项目经理或组长）提交PR（pull request）

## 十一、密码是纯数字的bug解决
### 11.1 在Readexcel中 getValue中
- String 方法
- 使用DecimalFormat类的format方法 //解决电话密码的问题

## 十二、改变读取user.xlsx的方式（getResourceAsStream的方式）
    路径不要写死 InputStream in

## 十三、解决用户名或密码错误，提示用户名重新输入
### 13.1 解决方案：循环

- while  不确定次数
- for 确定次数

- 代码格式化 CTRL+ALT+L

- tirm方法去掉 string中的 前后空格
#### 出了问题，把报错的具体信息复制出来，才能看的更清楚
 

## 十四、显示登陆成功后，显示商品信息
### 14.1 创建product.xlsx并添加商品信息

### 14.2 创建ReadProductExcel.java

### 14.3 创建Product.java

- 创建实体类（Bean）

### 14.4 修改 Product.java

- CellType type = cell.getCellTypeEnum()——>CellType type = cell.getCellType() 
    前面的久的  可能会出错（弃用过时的方法）

##### 要在实验楼的Cmdshop写报告


换分支 git checkout second

### 14.5 显示商品信息

```java
public static void main(String[] args) throws ClassNotFoundException {
        InputStream inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//输入流的方式，不要把路径写死
        Product[] products = new ReadProductExcel().readExcel(inPro);
        for (Product product : products) {
            //System.out.println(product.getId());
            System.out.print(product.getName());
            System.out.print("\t" + product.getPrice());
            System.out.println("\t" + product.getDesc());
        }
    }
```
/* 检测读取的商品信息*/



## 十五、把商品加入购物车
- 在ReadProductExcel中增加getProductById方法
```java
/**
* 根据ID查找商品
* @param id
* @param in
* @return 返回id对应的商品
*/
public Product getProductById(String id , InputStream in) {
    try {
        XSSFWorkbook xw = new XSSFWorkbook(in);
        XSSFSheet xs = xw.getSheetAt(0);//Sheet1 2 3
        for (int j = 1; j <= xs.getLastRowNum(); j++) { //最后一行行号  从第二行开始
            XSSFRow row = xs.getRow(j);
            Product product = new Product();
            for (int k = 0; k <= row.getLastCellNum(); k++) {
                XSSFCell cell = row.getCell(k);// k 0 1 用户名 密码
                if (cell == null)
                    continue;
                if (k == 0) { //用户名     k代表的是列
                    product.setId(this.getValue(cell));
                } else if (k == 1) {    //密码
                    product.setName(this.getValue(cell));
                } else if (k == 2) {       //地址
                    product.setPrice(Float.valueOf(getValue(cell)));//String转成Float 字符串转Float
                } else if (k == 3) {    //电话
                    product.setDesc(this.getValue(cell));
                }
                if(id.equals(product.getId())){
                    return product;
                }
                /*如果id(手动输入的)和product的id（从电子表格里读出来的）一致，则表示找到了该商品，然后返回该商品即可*/

            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;//如果找不到就返回空
}
```

- 调用getProductById查找商品并加入购物车
```java
/*遍历数组*/
int count=0;
Product productes[] = new Product[];//创建购物车（用数组模拟）
System.out.println("请输入商品的ID，把该商品加入购物车");
String pId=sc.next();
ReadProductExcel readProductExcel1 = new ReadProductExcel();
inPro=null;
inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//输入流的方式，不要把路径写死
Product product= readProductExcel1.getProductById(pId,inPro);
if(product!=null){
    //System.out.println("找到了该商品");
    /*把商品加入购物车 */
    productes[count++]=product;
}
```


## 十六、项目的意义

- 循环
- 接受键盘输入(Scanner:将来学习了I/O流以后，我们可以自己设计键盘输入（重复造车）)
- 如何创建对象
- 一个系统如何进行类的抽取，例如 User.java、Product.java,后面还有Order
- 类之间的关系
- POI读取excel数据 


## 十七、独立思考并完成Order.java




## 十八、退出程序
### 18.1 使用break
jstack 进程ID > log.txt，查看当前进程的详细信息（有哪些进程）
  把原本显示在控制台上的信息，输出到log.txt，方便查看
PID: Process ID




















