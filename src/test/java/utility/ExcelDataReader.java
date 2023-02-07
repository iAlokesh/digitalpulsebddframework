package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;;;

/**
 *  This class contains method for reading excel file
 *  
 * @author Alokesh Dey
 */
public class ExcelDataReader {
	
	// Variables
	
	XSSFWorkbook wb;
	
	/**
	 * Constructor of the class to find and read Excel file
	 */
	public ExcelDataReader() {
		
		File file = new File (System.getProperty("user.dir") + "//src//test//resources//TestData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
			
			try {
				wb = new XSSFWorkbook(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
	}
		
	// Methods
	
	/**
	 * Method for reading data from Excel file
	 * 
	 * @param sheetName should be passed as first parameter
	 * @param columnName should be passed as second parameter
	 * @param rowNumber should be passed as third parameter 
	 * 
	 * @return value celldata
	 */
	public String getDataFromTestcasePriority(String sheetName, String columnName, int rowNumber) {
		XSSFSheet sheet = wb.getSheet(sheetName);
        XSSFRow row = sheet.getRow(0);
        int col_num = -1;
        for(int i=0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals(columnName))
                col_num = i;
        }
        row = sheet.getRow(rowNumber-1);
        XSSFCell cell = row.getCell(col_num);
        String value = cell.getStringCellValue();
		return value;
	}
}
