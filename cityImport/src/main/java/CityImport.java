import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class CityImport {



    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\2026\\Desktop\\template_发电厂.xls";
        cityImport(path);
    }

    public static HashMap cityExport(String path) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(path);
        HSSFWorkbook hwb = new HSSFWorkbook(fileInputStream);
        HashMap<String, String> map = new HashMap<String, String>();

        if(hwb != null) {
            HSSFSheet sheet;
            HSSFRow row;

            for (int i = 0; i < hwb.getNumberOfSheets(); i++) {
                sheet = hwb.getSheetAt(i);
                for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++ ) {    //每行
                    row = sheet.getRow(j);
                    String s1 = row.getCell(0).toString();
                    String s2 = row.getCell(1).toString();
                    map.put(s1,s2);
                }
            }
        }
        return map;
    }
    public static void cityImport(String path) throws Exception{
        FileInputStream file = new FileInputStream(path);
        HashMap<String,String> map = cityExport("D:/cityCode.xls");
        HSSFWorkbook hwb = new HSSFWorkbook(file);
        if(hwb != null) {
            HSSFSheet sheet;
            HSSFRow row;
            HSSFCell cell;
            HSSFCell cell1;

            for (int i = 0; i < hwb.getNumberOfSheets(); i++) {
                sheet = hwb.getSheetAt(i);
                row = sheet.getRow(1);
                cell = row.getCell(3);
                System.out.println("修改前的cell：" + cell);
                sheet.createRow(1).createCell(3);
                cell.setCellValue("dangdangdang");
//                cell.setCellValue("dangdangdang");
                cell1 = row.getCell(3);
                System.out.println("修改后的cell：" + cell1);
//                for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {  //每行
//                    row = sheet.getRow(j);
//                    cell = row.getCell(3);
//
//                    String s1 = cell.toString();   //目标excel的城市名称
//                    for (Map.Entry<String, String> entry : map.entrySet()) {
////                        System.out.println(s1 + "======> " + entry.getKey());
//                        if(s1.equals(entry.getKey())) {
//                            cell.setCellValue(entry.getValue());
//                        }
//                        else {
//                            System.out.println("城市名称：" + s1);
//                        }
//                    }
//                }
            }
        }
        file.close();

    }
}
