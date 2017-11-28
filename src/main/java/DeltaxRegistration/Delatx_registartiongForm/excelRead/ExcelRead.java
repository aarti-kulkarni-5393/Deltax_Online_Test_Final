package DeltaxRegistration.Delatx_registartiongForm.excelRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.jna.platform.win32.WinDef.WPARAM;

public class ExcelRead {

	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public String datasets [][];
	public FileOutputStream fiout;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public static final Logger log = Logger.getLogger(ExcelRead.class.getName());
	
	public ExcelRead(String path) throws IOException {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public String[][] getData(String sheetName)
	{
	   sheet = workbook.getSheet(sheetName);
	   int total_row = sheet.getLastRowNum();
	  System.out.println(total_row);
     
       int total_column = sheet.getRow(0).getLastCellNum();
	   datasets = new String[total_row-1][total_column];
	   for (int i = 1; i <total_row; i++) {
		   row = sheet.getRow(i);
		   for (int j = 0; j < total_column; j++) {
		   XSSFCell cell = row.getCell(j);
		   
		   if (cell.getCellType()==cell.CELL_TYPE_STRING) {
				datasets[i-1][j]=cell.getStringCellValue();
			}
			else if (cell.getCellType()==cell.CELL_TYPE_NUMERIC) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				datasets[i-1][j] = cellText;
			}
			else {
				String cellText = String.valueOf(cell.getBooleanCellValue());
				datasets[i-1][j] = cellText;
			}
			   
		}
		
	}
		
	return datasets;
		
	}
	
	public void getCellData()
	{
		
		
		
	}

}
