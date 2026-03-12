package week6.day3;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadValuesFromxl {
	//Common Integration
//step4:change main to normal method
	
	//CI
	//Step1:Add the argumentd to method
	public static String[][] getvalue(String fileName) throws IOException {
		
		//Common integration
		//Step3:To change return type of method
		
		
		// Step1:Setting the excel file/workbook
		//CI
		//Step2:concatinate file name to path
		XSSFWorkbook wb = new XSSFWorkbook(
				"./Dynamicparam/"+fileName+".xlsx");
		// step 2:To get sheet from wb
		XSSFSheet sheet = wb.getSheetAt(0);
		// Step3:To get the row value
		XSSFRow row = sheet.getRow(0);

		 //System.out.println(row);
		// getLastRowNum();exclude header
		int lastRowNum = sheet.getLastRowNum();
		System.out.println(lastRowNum);

		// getphysicalnumberofrows-include header
		int physicalNumberofRows = sheet.getPhysicalNumberOfRows();
		System.out.println(physicalNumberofRows);

		// get the cell/column value
		XSSFCell cellrow = sheet.getRow(1).getCell(2);
		System.out.println(cellrow);

		// to get the cell value along with header
		int physicalnoofcells = sheet.getRow(1).getPhysicalNumberOfCells();
		System.out.println(physicalnoofcells);
		// getLastcellnum
		short lastcellNum = sheet.getRow(2).getLastCellNum();
		System.out.println(lastcellNum);

		//Common Integration
		//Step1: TO store the rows and columns
		String[][] data=new String[lastRowNum][lastcellNum];
		
	//Store cell values
	 XSSFCell cell=row.getCell(1);
	 
	 //outer is for row
	 for(int i=1;i<=lastRowNum;i++) {
		 
		 
		// inner is for column
		 for (int j = 0; j < lastcellNum; j++) {
			
			String stringcellvalue2=sheet.getRow(i).getCell(j).getStringCellValue();		
			System.out.println(data[i-1][j]=stringcellvalue2);
			
			//Common Integration
			//Step5:TO store the values from i and j
			data[i-1][j]=stringcellvalue2;
			
		 }
	 }wb.close();
	 //common integration
	 //step2:return data the string stored values
	 return data;
	
	}

}
