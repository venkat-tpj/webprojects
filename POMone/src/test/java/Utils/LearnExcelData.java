package Utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnExcelData {
	
	public static String[][] readData(String filenames, String sheetno) throws IOException {
		
		XSSFWorkbook book=new XSSFWorkbook("./msexceldata/"+filenames+".xlsx"); //To run multiple leads @one time
		XSSFSheet sheet = book.getSheetAt(0);
		//book.getNumberOfSheets(); To know how many sheets in workbook
		XSSFRow row = sheet.getRow(0);
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		int columnCount = row.getLastCellNum();
		System.out.println(columnCount);
		
		String[][] data=new String[rowCount][columnCount]; //dataprovider syntax 
		
		for (int i=1; i<=rowCount;i++) {
			for (int j=0; j<columnCount;j++) {
			String allData = sheet.getRow(i).getCell(j).getStringCellValue();
			//System.out.println(allData);
			// Assigning the excel data to the String[][] array
			data[i-1][j]=allData;  //String is converted into array //(1,0)(1,1)(1,2)
			System.out.println(allData);
 			}
		}
		
		book.close();
		return data;
	}
}
