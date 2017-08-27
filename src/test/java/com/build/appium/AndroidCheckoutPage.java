package com.build.appium;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndroidCheckoutPage {
	AndroidDriver<AndroidElement> driver=null;
	@AndroidFindBy(id = AndroidCheckoutConstants.ADDRESS)
    private MobileElement address;
	@AndroidFindBy(id = AndroidCheckoutConstants.CARD_NUMBER)
    private MobileElement cardNumber;
	@AndroidFindBy(id = AndroidCheckoutConstants.CITY)
    private MobileElement city;
	@AndroidFindBy(id = AndroidCheckoutConstants.CVV)
    private MobileElement cvv;
	@AndroidFindBy(id = AndroidCheckoutConstants.EMAIL)
    private MobileElement email;
	@AndroidFindBy(id = AndroidCheckoutConstants.EXPIRATION)
    private MobileElement expiration;
	@AndroidFindBy(id = AndroidCheckoutConstants.FULL_NAME)
    private MobileElement fullName;
	@AndroidFindBy(id = AndroidCheckoutConstants.ZIP)
    private MobileElement zip;
	@AndroidFindBy(id = AndroidCheckoutConstants.PHONE)
    private MobileElement phone;
	@AndroidFindBy(xpath = AndroidCheckoutConstants.PAYMENT)
    private MobileElement payment;
	@AndroidFindBy(xpath = AndroidCheckoutConstants.REVIEW)
    private MobileElement review;
	@AndroidFindBy(id = AndroidCheckoutConstants.TAX)
    private MobileElement tax;
	
	
	public AndroidCheckoutPage(AndroidDriver<AndroidElement> driver){
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	}
	public void checkOut() throws InterruptedException{
		email.sendKeys("shriram0205@gmail.com");
		fullName.sendKeys("Shriram Suryanarayanan");
		address.sendKeys("123 XYZ Street");
		zip.sendKeys("95050");
		city.sendKeys("Santa Clara");
		phone.sendKeys("6692386123");
		payment.click();
		Thread.sleep(2000);
		cardNumber.sendKeys("4111111111111111");
		expiration.sendKeys("12/17");
		cvv.sendKeys("000");
		review.click();
		Thread.sleep(2000);
		String value=tax.getText();
		Assert.assertEquals("$115.66", value);
		
		
	}
}
