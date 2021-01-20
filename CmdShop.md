# 项目目的
- 如何进行实体类的抽取
- 如何创建对象
- 如何给对象赋值
- 


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










