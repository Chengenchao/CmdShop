import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ReadExcel {
    /*
    readExcel是什么方法？成员方法
     */
    public User[] readExcel(File file) {
        User users[] = null;
        try {
            XSSFWorkbook xw = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet xs = xw.getSheetAt(0);//Sheet1 2 3
            users = new User[xs.getLastRowNum()]; //多少行就有多少个用户
            for (int j = 1; j <= xs.getLastRowNum(); j++) { //最后一行行号  从第二行开始
                XSSFRow row = xs.getRow(j);
                User user = new User();     //外循环，每循环一次，得一次用户信息
                for (int k = 0; k <= row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);// k 0 1 用户名 密码
                    if (cell == null)
                        continue;
                    if (k == 0) { //用户名     k代表的是列
                        //System.out.println("用户名：" + this.getValue(cell));
                        user.setUsername(this.getValue(cell));//获取格子的内容
                    } else if (k == 1) {    //密码
                        //System.out.println("密码：" + this.getValue(cell));
                        user.setPassword(this.getValue(cell));
                    } else if (k == 2) {       //地址
                        user.setAddress(this.getValue(cell));
                    } else if (k == 3) {    //电话
                        user.setPhone(this.getValue(cell));
                    }
                    users[j - 1] = user;//每循环一行 放入数组一次
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private String getValue(XSSFCell cell) {
        String value;
        CellType type = cell.getCellTypeEnum();

        switch (type) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BLANK:
                value = "";
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue() + "";
                break;
            case NUMERIC:
                value = cell.getNumericCellValue() + "";
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case ERROR:
                value = "非法字符";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }
}
