package DataDriven;

import org.apache.cassandra.db.rows.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class datadriven {
    public static void main(String[] args) throws IOException {
        FileInputStream fls=new FileInputStream("/home/abhay/Documents/datadriven.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fls);
        //File Input Stream Argument
        int sheets=workbook.getNumberOfSheets();
        for (int i = 0; i <sheets ; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata"));
            {
                XSSFSheet sheet = workbook.getSheetAt(i);
                //Identify Testcases column by scanning the entire 1st row
                Iterator<Row> rows = sheet.iterator(); //sheet is the collection of the row
                Row firstrow = rows.next();
                Iterator<Cell> ce = firstrow.cellIterator();//row is the collection of the cells
                ce.next();
                int k = 0;
                while (ce.hasNext()) {
                    Cell value = ce.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
                        System.out.println(k + 1);
                        System.out.println("pass");
                    }
                    k++;
                }


                while (rows.hasNext())
                {
                    Row r=rows.next();
                  if(r.getCell(k).getStringCellValue().equalsIgnoreCase("purchase"));
                    {

                    }

                }
            }
        }
    }
}
