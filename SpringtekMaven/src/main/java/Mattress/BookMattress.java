package Mattress;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import spinktek.search.pkg.SearchRepository;

public class BookMattress {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://springtek.in");

		driver.findElement(By.linkText("Mattresses")).click();
		driver.navigate().forward();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div/div[2]/div[1]/h2/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 150)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		for (int i = 1; i <= 8; i++) {
			SearchRepository.dualImage(driver, i).click();
		}

		SearchRepository.viewVerify(driver).click();
		driver.findElement(By.className("viewbtn"));
		Thread.sleep(3000);
		driver.navigate().back();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(5000);
		js.executeScript("scroll(0, 400)");
		try {
			SearchRepository.mattSize(driver).click();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			js.executeScript("scroll(0, 600)");
			SearchRepository.mattDimention(driver).click();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Select s = new Select(SearchRepository.matt_height(driver));
			s.selectByVisibleText("8 inch - 20.32 cm");
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
	}

}
