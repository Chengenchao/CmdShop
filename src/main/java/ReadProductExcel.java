import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;


public class ReadProductExcel {
    /**
     * 返回所有的商品
     * @param in
     * @return 包含所有商品的数组
     */
    public Product[] getAllProduct(InputStream in) {
        Product products[] = null;
        try {
            XSSFWorkbook xw = new XSSFWorkbook(in);
            XSSFSheet xs = xw.getSheetAt(0);//Sheet1 2 3
            products = new Product[xs.getLastRowNum()]; //多少行就有多少个用户
            for (int j = 1; j <= xs.getLastRowNum(); j++) { //最后一行行号  从第二行开始
                XSSFRow row = xs.getRow(j);
                Product product = new Product();
                for (int k = 0; k <= row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);// k 0 1 用户名 密码
                    if (cell == null)
                        continue;
                    if (k == 0) { //     k代表的是列
                        product.setId(this.getValue(cell));
                    } else if (k == 1) {    //
                        product.setName(this.getValue(cell));
                    } else if (k == 2) {       //
                        product.setPrice(Float.valueOf(getValue(cell)));//String转成Float 字符串转Float
                    } else if (k == 3) {    //
                        product.setDesc(this.getValue(cell));
                    }
                    products[j - 1] = product;//每循环一行 放入数组一次
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

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
                    if (k == 0) { //     k代表的是列
                        product.setId(this.getValue(cell));
                    } else if (k == 1) {    //
                        product.setName(this.getValue(cell));
                    } else if (k == 2) {       //
                        product.setPrice(Float.valueOf(getValue(cell)));//String转成Float 字符串转Float
                    } else if (k == 3) {    //
                        product.setDesc(this.getValue(cell));
                    }

                    /*如果id(手动输入的)和product的id（从电子表格里读出来的）一致，则表示找到了该商品，然后返回该商品即可*/

                }
                if(id.equals(product.getId())){
                    return product;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;//如果找不到就返回空
    }





    private String getValue(XSSFCell cell) {
        String value;
        CellType type = cell.getCellType();

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
                DecimalFormat df = new DecimalFormat("#");
                value = df.format(cell.getNumericCellValue());
                /* = cell.getNumericCellValue() + "";//非字符串类型和一个空字符串相连，最终类型是string
                int index=value.lastIndexOf(".");
                value=value.substring(0,index);*/
                //System.out.println("处理后的：" + value);
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
