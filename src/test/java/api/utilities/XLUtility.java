package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook xssfWorkbook;
	public XSSFSheet xssfSheet;
	public XSSFRow xssfRow;
	public XSSFCell xssfCell;
	public CellStyle style;
	String path;
	
	public XLUtility(String path)
	{
		this.path=path;
	}

	public int getRowCount(String sheetName) throws IOException
	{
	     fi= new FileInputStream(path);
	     xssfWorkbook = new XSSFWorkbook(fi);
	     xssfSheet=xssfWorkbook.getSheet(sheetName);
	     int rowCount=xssfSheet.getLastRowNum();
	     xssfWorkbook.close();
	     fi.close();
	     return rowCount;
	}
	
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		fi= new FileInputStream(path);
	     xssfWorkbook = new XSSFWorkbook(fi);
	     xssfSheet=xssfWorkbook.getSheet(sheetName);
	     xssfRow= xssfSheet.getRow(rownum);
	     int cellCount=xssfRow.getLastCellNum();
	     xssfWorkbook.close();
	     fi.close();
	     return cellCount;
	}
	
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		 fi= new FileInputStream(path);
	     xssfWorkbook = new XSSFWorkbook(fi);
	     xssfSheet=xssfWorkbook.getSheet(sheetName);
	     xssfRow=xssfSheet.getRow(rownum);
	     xssfCell=xssfRow.getCell(colnum);
	     
	     DataFormatter dr=new DataFormatter();
	     String data="";
	     try {
			data=dr.formatCellValue(xssfCell);
		} catch (Exception e) {
			
			System.out.println(e.getStackTrace());
		}
	     xssfWorkbook.close();
	     fi.close();
	     return data;
	     
	}
}
