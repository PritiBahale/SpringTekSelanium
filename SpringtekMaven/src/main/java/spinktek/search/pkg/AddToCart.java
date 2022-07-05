package spinktek.search.pkg;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import fileRead.sprinktek.pkg.ReadFile;

public class AddToCart {
	
	
	public static void addToCart(WebDriver driver ,String item) throws InterruptedException, IOException {
		Select s = new Select(SearchRepository.quantity_id(driver));
		s.selectByValue("4");
		String qty = s.getFirstSelectedOption().getText();
		Thread.sleep(5000);

		String up = SearchRepository.unitPrice(driver).getText();
		Thread.sleep(3000);

		String tp = SearchRepository.totalPrice(driver).getText();

		// System.out.println(SearchRepository.totalPrice(driver).getText());
		Thread.sleep(3000);

		System.out.println(item + " Quantity: " + qty + "  ||  Unit Price: " + up + "  ||  Total Price: " + tp);

		XSSFSheet c_sh = ReadFile.readF("coupon");
		int c_size = c_sh.getLastRowNum();
		for (int k = 0; k <= c_size; k++) {
			String coupon = c_sh.getRow(k).getCell(0).toString();
			SearchRepository.txtbox_Coupon(driver).clear();
			SearchRepository.txtbox_Coupon(driver).sendKeys(coupon);
			Thread.sleep(3000);
			SearchRepository.applyCoupButton(driver).click();

		}

		// SearchRepository.applycouponText(driver).getText();
		Thread.sleep(5000);
		System.out.println(SearchRepository.applycouponTextMsg(driver).getText());
		Thread.sleep(5000);
		SearchRepository.checkoutbtn(driver).click();
		
	}

}
