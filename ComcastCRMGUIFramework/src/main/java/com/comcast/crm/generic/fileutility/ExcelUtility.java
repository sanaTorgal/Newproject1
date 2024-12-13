package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String getdataFromExcel(String sheetname,int rownum,int colnum) throws Throwable
	{
		//FileInputStream fis=new FileInputStream(".\\testdata\\testscriptdata.xlsx");
		FileInputStream fis=new FileInputStream(Ipathconstant.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
//		String data=wb.getSheet(sheetname).getRow(rownum).getCell(colnum).getStringCellValue();
		
		Cell cell = wb.getSheet(sheetname).getRow(rownum).getCell(colnum);
		DataFormatter data = new DataFormatter();
		String data1 = data.formatCellValue(cell);
		wb.close();
		return data1;
	
	}
	
	public int getRowcount(String sheetname)throws Throwable
	{

		//FileInputStream fis=new FileInputStream(".\\testdata\\testscriptdata.xlsx");
		FileInputStream fis=new FileInputStream(Ipathconstant.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		int rownum=wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rownum;
		
	}
	public void setdataIntoExcel(String sheetname,int rownum,int colnum,String data)throws Throwable
	{
		//FileInputStream fis=new FileInputStream(".\\testdata\\testscriptdata.xlsx");
		FileInputStream fis=new FileInputStream(Ipathconstant.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).createCell(colnum);
		
		FileOutputStream fos=new FileOutputStream(".\\testdata\\testscriptdata.xlsx");
		wb.write(fos);
		wb.close();
		
		
		
		
		
	}
}
