package com.build.appium;

import org.testng.annotations.Test;
import build.com.AndroidBaseTest;

public class AndroidCheckoutTest extends AndroidBaseTest {
	AndroidOrderPage order;
	AndroidCheckoutPage checkOut;
	@Test
	public void performTest() throws InterruptedException{
	order = new AndroidOrderPage(driver);
	checkOut= order.placeOrder();
	checkOut.checkOut();
}

}
