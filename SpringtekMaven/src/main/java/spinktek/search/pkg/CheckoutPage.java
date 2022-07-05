package spinktek.search.pkg;

import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	public static void checkout(WebDriver driver) {
		
		SearchRepository.fname(driver).sendKeys("ABCDE");
		SearchRepository.lastName(driver).sendKeys("XYZ");
		SearchRepository.mobileNo(driver).sendKeys("45698712323");
		SearchRepository.emailAdd(driver).sendKeys("abcd@gmail.com");
		SearchRepository.address(driver).sendKeys("mnop");
		SearchRepository.instruction(driver).sendKeys("jklmnop");
		SearchRepository.landmark(driver).sendKeys("near petrol pamp");
		SearchRepository.pincode(driver).sendKeys("442255");
		SearchRepository.city(driver).sendKeys("ABCDE");
		SearchRepository.state(driver).sendKeys("ABCDE");
		SearchRepository.ckboxagree(driver).click();


	}

}
