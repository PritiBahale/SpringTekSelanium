package spinktek.search.pkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchRepository {

	private static WebElement element;

	public static WebElement search(WebDriver driver) {
		element = driver.findElement(By.name("searchbox"));
		return element;
	}

	public static WebElement dualConf(WebDriver driver) {
		element = driver.findElement(By.cssSelector("a[href='https://springtek.in/dual-comfort']"));
		return element;
	}

	public static WebElement dualImage(WebDriver driver, int j) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		element = driver.findElement(By.xpath("//*[@id=\"magnific\"]/div/div/div/div[1]/div/div/a[" + j + "]/img"));
		Thread.sleep(2000);
		return element;
	}

	public static WebElement mattSize(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		element = driver.findElement(By.cssSelector("input[value='Queen']"));
		Thread.sleep(2000);
		return element;
	}

	public static WebElement mattDimention(WebDriver driver) throws InterruptedException {
		element = driver.findElement(By.cssSelector("input[value='75\"x60\"']"));
		Thread.sleep(2000);
		return element;
	}

	public static WebElement matt_height(WebDriver driver) {
		element = driver.findElement(By.name("mattress height"));
		return element;
	}

	public static WebElement ddlquantity(WebDriver driver) {
		element = driver.findElement(By.id("ddlquantity"));
		return element;
	}

	public static WebElement pinCode(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		element = driver.findElement(By.id("txtpincodecheck"));
		Thread.sleep(2000);
		return element;
	}

	public static WebElement addToCart(WebDriver driver) throws InterruptedException {

		element = driver.findElement(By.id("btngotocart"));
		return element;
	}

	public static WebElement viewVerify(WebDriver driver) {
		element = driver.findElement(By.cssSelector("a[href='/natural-latex-mattress-certificate']"));
		return element;
	}

	public static WebElement quantity_id(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"bindcartitems\"]/div[1]/div/div[1]/div[2]/div[2]/select"));
		return element;
	}

	public static WebElement unitPrice(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"bindcartitems\"]/div[1]/div/div[1]/div[2]/div[3]/h5[2]/span"));
		return element;
	}

	public static WebElement totalPrice(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"bindcartitems\"]/div[1]/div/div[1]/div[2]/div[5]/h5[2]/span"));
		return element;
	}

	public static WebElement txtbox_Coupon(WebDriver driver) {
		element = driver.findElement(By.id("txtcouponcode"));
		return element;
	}

	public static WebElement applycouponTextMsg(WebDriver driver) {
		element = driver.findElement(By.className("after-coupon-apply"));
		return element;
	}

	public static WebElement applyCoupButton(WebDriver driver) {
		element = driver.findElement(By.id("btncouponcode"));
		return element;
	}

	public static WebElement checkoutbtn(WebDriver driver) {
		element = driver.findElement(By.id("btngotocheckout"));
		return element;

	}

	public static WebElement fname(WebDriver driver) {
		element = driver.findElement(By.id("txtfname"));
		return element;
	}

	public static WebElement lastName(WebDriver driver) {
		element = driver.findElement(By.id("txtlname"));
		return element;
	}

	public static WebElement mobileNo(WebDriver driver) {
		element = driver.findElement(By.id("txtmobile"));
		return element;
	}
	
	public static WebElement emailAdd(WebDriver driver) {
		element = driver.findElement(By.id("txtemail"));
		return element;
	}
	
	public static WebElement address(WebDriver driver) {
		element = driver.findElement(By.id("txtaddress"));
		return element;
	}
	
	public static WebElement instruction(WebDriver driver) {
		element = driver.findElement(By.id("txtinstruction"));
		return element;
	}
	
	public static WebElement landmark(WebDriver driver) {
		element = driver.findElement(By.id("txtlandmark"));
		return element;
	}
	
	public static WebElement pincode(WebDriver driver) {
		element = driver.findElement(By.id("txtpincode"));
		return element;
	}
	
	public static WebElement city(WebDriver driver) {
		element = driver.findElement(By.id("txtcity"));
		return element;
	}
	
	public static WebElement state(WebDriver driver) {
		element = driver.findElement(By.id("txtstate"));
		return element;
	}
	public static WebElement ckboxagree(WebDriver driver) {
		element = driver.findElement(By.id("ckboxagree"));
		return element;
	}
	
	
}
