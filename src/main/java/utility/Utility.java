package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String screenShot(WebDriver driver) throws IOException {
		 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String screenshotPath=System.getProperty("user.dir")+"/Screenshots/SauceLab_"+getCurrentDateTime()+".png";
		 File Destination=new File(screenshotPath);
		 FileHandler.copy(source, Destination);
		 
		 return screenshotPath;
	}
	
	public static String[][] getData() throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("D:\\Selenium_Drivers\\TestData.xlsx");
		
		Sheet SHEET = null;
		String[][] arrayExcelData = null;
		try {
			SHEET = WorkbookFactory.create(file).getSheet("Sheet1");
			
			int totalNoOfRows = SHEET.getLastRowNum();
			int totalNoOfCols = SHEET.getRow(0).getLastCellNum();
			System.out.println(totalNoOfRows+"   "+totalNoOfCols);
			
			arrayExcelData = new String[totalNoOfRows][totalNoOfCols];
			
			for (int i= 1 ; i <= totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = SHEET.getRow(i).getCell(j).getStringCellValue();

				}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arrayExcelData;
		
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date curDate=new Date();
		return customFormat.format(curDate);
	}

	/*public static void getTestData(int row,int col) throws EncryptedDocumentException, IOException, InvalidFormatException {
		
		FileInputStream file=new FileInputStream("D:\\Selenium_Drivers\\TestData.xlsx");
		Sheet sh=WorkbookFactory.create(file).getSheet("Sheet1");
		
		//Fetch String value
		String uname=sh.getRow(1).getCell(0).getStringCellValue();
		System.out.println(uname);
		
		String pwd=sh.getRow(1).getCell(1).getStringCellValue();
		System.out.println(pwd);
	}*/

}
