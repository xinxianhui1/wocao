package demo.POI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class POI {

    public static void main(String[] args) throws Exception{
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(5);
        XSSFCell cell = row.createCell(5);
        cell.setCellValue("测试");

        FileOutputStream out=new FileOutputStream("C:/Users/Administrator/Desktop/POI.xlsx");

        workbook.write(out);
    }


    @Test
    public void getSheet () throws Exception {
        //传统模式读取Excel表格内容
        FileInputStream in=new FileInputStream("C:/Users/Administrator/Desktop/POI.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(in);
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        XSSFRow row = sheetAt.getRow(5);
        XSSFCell cell = row.getCell(5);
        String value = cell.getStringCellValue();
        System.out.println(value);
    }

    @Test
    public void getSheet2 () throws Exception {
        //工厂模式读取Excel表格内容
        FileInputStream in=new FileInputStream("C:/Users/Administrator/Desktop/POI.xlsx");
        Workbook workbook=WorkbookFactory.create(in);
        Sheet sheetAt = workbook.getSheetAt(0);
        Row row = sheetAt.getRow(5);
        Cell cell = row.getCell(5);
        String value = cell.getStringCellValue();
        System.out.println(value);
    }

    @Test
    public void getSheet3() throws Exception{
        FileInputStream in=new FileInputStream("C:/Users/Administrator/Desktop/Demo.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(in);
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        int rows = sheetAt.getPhysicalNumberOfRows();
        for (int i=0;i<rows;i++){
            XSSFRow row = null;
            int cells = 0;
            if(sheetAt.getRow(i)!=null){
                row = sheetAt.getRow(i);
                cells = row.getPhysicalNumberOfCells();
            }else{
                i=i+1;
            }

            for (int j=0;j<cells;j++){
                String CellValue=null;

                XSSFCell cell = null;
                if(row.getCell(j)!=null){
                   cell = row.getCell(j);

                    cell.setCellType(CellType.STRING);
                    CellValue = cell.getStringCellValue();
                }else{
                    j=j+1;
                }

                System.out.print(CellValue+"    ");
            }
            System.out.println();
        }

    }
}
