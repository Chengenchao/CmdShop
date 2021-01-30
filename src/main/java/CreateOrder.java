import java.io.FileOutputStream;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateOrder {
    public static String outputFile = "D:\\BluePractice\\CmdShop\\src\\Orders.xlsx";
    //System.out.println("user.dir")+Flie.separator + "Order.xlsx";//是在项目目录下的生成
    public static void createOrder(Order order) {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("订单");

                HSSFRow firstrow = sheet.createRow(0);
                HSSFCell cell01 = firstrow.createCell(0);
                HSSFCell cell02 = firstrow.createCell(1);
                HSSFCell cell03 = firstrow.createCell(2);
                HSSFCell cell04 = firstrow.createCell(3);
                HSSFCell cell05 = firstrow.createCell(4);
                HSSFCell cell06 = firstrow.createCell(5);

                cell01.setCellValue("用户");
                cell02.setCellValue("商品");
                cell03.setCellValue("购买数量");
                cell04.setCellValue("商品总价");
                cell05.setCellValue("实付款");
                cell06.setCellValue("下单时间");


                //外循环的次数与购物车的实际长度有关
            for(int i = 0; i < order.getProduct().length; i++) {
                HSSFRow row = sheet.createRow((short)i+1);
                for(int j = 0; j < 6; j++) {
                    HSSFCell cell = row.createCell((short)j);
                    int pId=Integer.parseInt(order.getProduct()[i].getId());
                    if(j==0){
                        cell.setCellValue(order.getUser().getUsername());
                        //cell.setCellStyle(style);//设置背景色
                    }else if(j==1){
                        cell.setCellValue(pId);
                    }else if(j==2){/*遍历map*/
                        //目录key 内容value
                        Map<Integer,Integer> ammount=order.getAmmount();
                        int productNum=ammount.get(pId);
                        cell.setCellValue(productNum);

                    }else if(j==3){
                        cell.setCellValue(order.getTotalPay());
                    }else if(j==4){
                        cell.setCellValue(order.getActualPay());
                    }else if(j==5){
                        cell.setCellValue(order.getOrderDate());
                    }
                    //cellj.setCellValue([i][j]);
                }
            }

            FileOutputStream fOut = new FileOutputStream(outputFile);
            workbook.write(fOut);
            fOut.flush();
            fOut.close();
            System.out.println("文件生成...");
        } catch (Exception var20) {
            System.out.println("已运行 xlCreate() : " + var20);
        }

    }


}
