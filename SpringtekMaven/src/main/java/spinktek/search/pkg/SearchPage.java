package spinktek.search.pkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import fileRead.sprinktek.pkg.ReadFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchPage {
	static WebDriver driver;
	static JavascriptExecutor js = null;

	public static void main(String[] args) throws IOException, InterruptedException {
		XSSFSheet sh = ReadFile.readF("search");

		int size = sh.getLastRowNum();
		System.out.println("Row size " + size);

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://springtek.in");
		for (int i = 1; i < size; i++) {

			String item = sh.getRow(i).getCell(0).toString();
			System.out.println(item);

			Actions act = new Actions(driver);

			WebElement search = driver.findElement(By.name("searchbox"));
			act.moveToElement(search).doubleClick().build().perform();
			Thread.sleep(3000);
			act.moveToElement(search).sendKeys(item).click().build().perform();
			Thread.sleep(3000);

			WebElement Dual_conf = driver.findElement(By.cssSelector("a[href='https://springtek.in/dual-comfort']"));
			try {
				SearchPage.jsScroll(500);
				Dual_conf.click();
			} catch (Exception e) {
				System.out.println(e);
			}
			/*
			 * for (int j = 1; j <= 6; j++) { SearchRepository.dualImage(driver, j).click();
			 * }
			 */
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			Thread.sleep(5000);
			SearchPage.jsScroll(400);
			// js.executeScript("scroll(0, 400)");
			try {
				SearchRepository.mattSize(driver).click();
			} catch (Exception e) {
				System.out.println(e);
			}
			try {
				SearchPage.jsScroll(600);
				SearchRepository.mattDimention(driver).click();
			} catch (Exception e) {
				System.out.println(e);
			}

			try {
				Select s = new Select(SearchRepository.matt_height(driver));
				s.selectByVisibleText("5 inch - 12.70 cm");
			} catch (Exception e) {
				System.out.println(e);
			}
			try {
				Select sq = new Select(SearchRepository.ddlquantity(driver));
				sq.selectByVisibleText("3N");
			} catch (Exception e) {
				System.out.println(e);
			}

			SearchRepository.pinCode(driver).sendKeys("4411001");
			SearchRepository.addToCart(driver).click();
			try {
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
			} catch (Exception e) {
				System.out.println(e);
			}

			AddToCart.addToCart(driver, item);
			js = (JavascriptExecutor) driver;
			SearchRepository.fname(driver).sendKeys("ABCDE");
			SearchRepository.lastName(driver).sendKeys("XYZ");
			SearchRepository.mobileNo(driver).sendKeys("45698712323");
			SearchRepository.emailAdd(driver).sendKeys("abcd@gmail.com");
			SearchRepository.address(driver).sendKeys("mnop");
			SearchRepository.instruction(driver).sendKeys("jklmnop");
			SearchRepository.landmark(driver).sendKeys("near petrol pamp");
			SearchRepository.pincode(driver).sendKeys("442255");

			SearchPage.jsScroll(400);
			SearchRepository.city(driver).sendKeys("ABCDE");
			SearchRepository.state(driver).sendKeys("ABCDE");
			// SearchRepository.ckboxagree(driver).click();
			WebElement chk = SearchRepository.ckboxagree(driver);
			js.executeScript("arguments[0].click();", chk);

		}
		driver.close();
	}

	public static void jsScroll(int val) {
		js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0," + val + ")");
	}
}
