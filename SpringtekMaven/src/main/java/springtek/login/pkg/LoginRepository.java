package springtek.login.pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginRepository {
	static WebElement element;

	public static WebElement un_email(WebDriver driver) {
		element = driver.findElement(By.id("loginEmailAddress"));
		return element;
	}

	public static WebElement login_pw(WebDriver driver) {
		element = driver.findElement(By.id("loginPassword"));
		return element;
	}

	public static WebElement login(WebDriver driver) {
		element = driver.findElement(By.id("login_submit"));
		return element;
	}

	public static WebElement login_result(WebDriver driver) {
		element = driver.findElement(By.id("login_result"));
		return element;
	}
}
