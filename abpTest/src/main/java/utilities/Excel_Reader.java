package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	
	
			public FileOutputStream fileOut = null;
			public String path;
			public FileInputStream fis;
			public XSSFWorkbook workbook;
			public XSSFSheet sheet;
			public XSSFRow row;
			public XSSFCell cell;


			
			public Excel_Reader(String path) {
				
				this.path = path;
				try {
					fis = new FileInputStream(path);
					workbook = new XSSFWorkbook(fis);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			@SuppressWarnings({ "deprecation" })
			public String[][] getDataFromExcel(String sheetName, String ExcelName) {
				
				String dataSets[][] = null;
							
					try {
						XSSFSheet sheet = workbook.getSheet(sheetName);
						int totalRow = sheet.getLastRowNum()+1;
						int totalColumn = sheet.getRow(0).getLastCellNum();
						dataSets = new String[totalRow - 1][totalColumn];
						//log("total Row is : "+totalRow +"  and total Column is : "+ totalColumn);
						for (int i = 1; i < totalRow; i++) {
							XSSFRow rows = sheet.getRow(i);
							for (int j = 0; j < totalColumn; j++) {
								XSSFCell cell = rows.getCell(j);
							
								if (cell.getCellType() == Cell.CELL_TYPE_STRING)
									dataSets[i - 1][j] = cell.getStringCellValue();
								else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
									String cellText = String.valueOf(cell.getNumericCellValue());
									dataSets[i - 1][j] = cellText;
								} else
									dataSets[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
							}

						}
						return dataSets;
					} catch (Exception e) {
						System.out.println("Exception in reading Xlxs file" + e.getMessage());
						e.printStackTrace();
					}
					return dataSets;
				}
			}
