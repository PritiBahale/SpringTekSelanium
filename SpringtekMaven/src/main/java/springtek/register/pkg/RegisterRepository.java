package springtek.register.pkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterRepository {
	static WebElement element;

	public static WebElement pw(WebDriver driver) {
		element = driver.findElement(By.id("txtPassword"));
		return element;
	}

	public static WebElement login(WebDriver driver) {
		element = driver.findElement(By.id("btnLogin"));
		return element;
	}

	public static WebElement firstName(WebDriver driver) {
		element = driver.findElement(By.id("firstname"));
		return element;
	}
	
	public static WebElement lastName(WebDriver driver) {
		element = driver.findElement(By.id("lastname"));
		return element;
	}

	public static WebElement email(WebDriver driver) {
		element = driver.findElement(By.id("emailAddress"));
		return element;
	}
	
	public static WebElement password(WebDriver driver) {
		element = driver.findElement(By.id("password"));
		return element;
	}
	
	public static WebElement conf_pass(WebDriver driver) {
		element = driver.findElement(By.id("confirmPassword"));
		return element;
	}
	
	public static WebElement mobileNumber(WebDriver driver) {
		element = driver.findElement(By.id("mobileNumber"));
		return element;
	}

	public static WebElement checkbox(WebDriver driver) {
		element= driver.findElement(By.id("regtermsCheck"));
		return element;
	}
	

}
