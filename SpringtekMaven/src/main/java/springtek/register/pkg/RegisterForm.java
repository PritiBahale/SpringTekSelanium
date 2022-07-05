package springtek.register.pkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import fileRead.sprinktek.pkg.ReadFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterForm {

	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		XSSFSheet sh = ReadFile.readF("register");

		int size = sh.getLastRowNum();
		System.out.println("Row size " + size);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://springtek.in/Register");

		for (int i = 1; i <= size; i++) {

			String first_name = sh.getRow(i).getCell(0).toString();
			String last_name = sh.getRow(i).getCell(1).toString();
			String email = sh.getRow(i).getCell(2).toString();
			String pw = sh.getRow(i).getCell(3).toString();
			String conf_pw = sh.getRow(i).getCell(4).toString();
			String mob = sh.getRow(i).getCell(5).toString();

			System.out.println(first_name + "    " + last_name);
			
			RegisterRepository.firstName(driver).sendKeys(first_name);
			RegisterRepository.lastName(driver).sendKeys(last_name);
			RegisterRepository.email(driver).sendKeys(email);
			RegisterRepository.password(driver).sendKeys(pw);
			RegisterRepository.conf_pass(driver).sendKeys(conf_pw);
			RegisterRepository.mobileNumber(driver).sendKeys(mob);
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement checkbox = driver.findElement(By.id("regtermsCheck"));
			js.executeScript("arguments[0].click();", checkbox);

			WebElement fv = driver.findElement(By.id("RegFirstNumber"));
			int v1 = Integer.parseInt(fv.getAttribute("value"));

			WebElement sv = driver.findElement(By.id("RegSecondNumber"));
			int v2 = Integer.parseInt(sv.getAttribute("value"));
			int Result = (v1 + v2);
			WebElement RegResult = driver.findElement(By.id("RegResult"));
			RegResult.sendKeys(Integer.toString(Result));

			js.executeScript("scroll(0, 250)");
			WebElement regbtn = driver.findElement(By.id("register_submit"));
			js.executeScript("arguments[0].click();", regbtn);

			Thread.sleep(5000);
			driver.navigate().refresh();

		}
		driver.close();

	}

}
