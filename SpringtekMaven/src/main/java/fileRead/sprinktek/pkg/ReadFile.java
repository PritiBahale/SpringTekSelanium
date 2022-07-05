package fileRead.sprinktek.pkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile 
{
	public static XSSFSheet readF(String shname) throws IOException {
		
		File f = new File("Data/springtek_cred.xlsx");
		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook wk = new XSSFWorkbook(fis);
		XSSFSheet sh = wk.getSheet(shname);
		return sh;
		
	}
}
