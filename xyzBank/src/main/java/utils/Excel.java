package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	    public static String getCellValue(String xl, String Sheet, int r, int c){

	          try{
	        	  FileInputStream fis = new FileInputStream(xl);
                  XSSFWorkbook wb = new XSSFWorkbook(fis);
                  Cell cell = wb.getSheet(Sheet).getRow(r).getCell(c);
                  return cell.getStringCellValue();
                 }catch (IOException e)
	          	  {
                	 return "";
	          	  }

	           }

	    public static int getRowCount (String xl, String Sheet){
	    	
	    	try{
	    		 FileInputStream fis = new FileInputStream(xl);
	             Workbook wb = WorkbookFactory.create(fis);
	             return wb.getSheet(Sheet).getLastRowNum();

	            }catch (Exception e)
	    		 {
	            	return 0;
	             }

	           }
	    
	    public static double setCellValue(String xl, String Sheet, int r, int c, int value){

	          try{
	        	  FileInputStream fis = new FileInputStream(xl);
	              XSSFWorkbook wb = new XSSFWorkbook(fis);
	              Cell cell = wb.getSheet(Sheet).getRow(r).getCell(c);
	              cell.setCellValue(value);
	              fis.close();
	              FileOutputStream fos = new FileOutputStream(xl);
	              wb.write(fos);
	              fos.close();
	              return value;
	              }catch (IOException e)
		          	  {
	              	 return 0;
		          	  }

	           }
}
