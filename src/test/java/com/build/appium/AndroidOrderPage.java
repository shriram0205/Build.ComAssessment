package com.build.appium;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import com.build.order.OrderConstants;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndroidOrderPage {
	AndroidDriver<AndroidElement> driver=null;
	@AndroidFindBy(id = AndroidOrderConstants.SEARCH_TXT)
    private MobileElement searchTxt;
	@AndroidFindBy(xpath = AndroidOrderConstants.SUEDE)
    private MobileElement suede;
	@AndroidFindBy(xpath = AndroidOrderConstants.ADD_CART)
    private MobileElement addCart;
	@AndroidFindBy(xpath = AndroidOrderConstants.CASHMERE)
    private MobileElement cashmere;
	@AndroidFindBy(xpath = AndroidOrderConstants.INCREMENT)
    private MobileElement increment;
	@AndroidFindBy(xpath = AndroidOrderConstants.CHECKOUT)
    private MobileElement checkout;
	@AndroidFindBy(xpath = AndroidOrderConstants.GUEST_LOGIN)
    private MobileElement guestLogin;
	@AndroidFindBy(id = OrderConstants.GRAND_TOTAL)
    private MobileElement grandTotal;
	
	public AndroidOrderPage(AndroidDriver<AndroidElement> driver){
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	}
	
	public AndroidCheckoutPage placeOrder() throws InterruptedException{
		searchTxt.sendKeys("Suede Kohler K-6626- 6U");
		searchTxt.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		suede.click();
		addCart.click();
		Thread.sleep(2000);
		searchTxt.sendKeys("Cashmere Kohler K-6626- 6U");
		searchTxt.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		cashmere.click();
		addCart.click();
		searchTxt.sendKeys("Kohler K-5180- ST");
		searchTxt.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		increment.click();
		addCart.click();
		Thread.sleep(2000);
		String value=grandTotal.getText();
		Assert.assertEquals("$1,595.18", value);
		checkout.click();
		guestLogin.click();
	    return new AndroidCheckoutPage(driver);
	}
	
}
