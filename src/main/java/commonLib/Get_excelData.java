package commonLib;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Get_excelData {

	public Object[][] get_excelData(String filepath, String sheetname) throws Exception {
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetname);
		
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[rows-1][cols];
		
		for(int row = 0; row < rows-1; row++) {
			for(int col = 0; col < cols; col++) {
				
				DataFormatter formatter = new DataFormatter();
				
				data[row][col] = formatter.formatCellValue(sheet.getRow(row+1).getCell(col)); 
			}
		}
		
		wb.close();
		fis.close();		
		return data;	
	}
	
}
