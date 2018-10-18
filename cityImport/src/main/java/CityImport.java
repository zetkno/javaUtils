import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zetkno on 2018/10/18.
 */

public class CityImport {


    public static final String CITY_CODE = "D:/cityCode.xls";

    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\2026\\Desktop\\webData\\template_填埋.xls";
        cityImport(path);
    }

    public static HashMap cityExport() throws Exception{
        FileInputStream fileInputStream = new FileInputStream(CITY_CODE);
        HSSFWorkbook hwb = new HSSFWorkbook(fileInputStream);
        HashMap<String, String> map = new HashMap<String, String>();

        if(hwb != null) {
            HSSFSheet sheet;
            HSSFRow row;

            for (int i = 0; i < hwb.getNumberOfSheets(); i++) {
                sheet = hwb.getSheetAt(i);
                for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++ ) {
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

        HashMap<String,String> map = cityExport();
        HSSFWorkbook hwb = new HSSFWorkbook(file);
        if(hwb != null) {
            HSSFSheet sheet;
            HSSFRow row;
            HSSFCell cell;

            for (int i = 0; i < hwb.getNumberOfSheets(); i++) {
                sheet = hwb.getSheetAt(i);
                for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
                    row = sheet.getRow(j);
                    cell = row.getCell(3);
                    String s1 = cell.toString();   //目标excel的城市名称
                    for (Map.Entry<String, String> entry : map.entrySet()) {

                        if(s1.equals(entry.getKey())) {
                            cell.setCellValue(entry.getValue());
                            continue;
                        }
                        else {
                            continue;
                        }
                    }
                }
                FileOutputStream out = null;
                try {
                    out = new FileOutputStream(path);
                    hwb.write(out);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        file.close();
    }

}
