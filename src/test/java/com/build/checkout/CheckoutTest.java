package com.build.checkout;

import org.testng.annotations.Test;
import com.build.order.OrderPage;
import build.com.BaseTest;

public class CheckoutTest extends BaseTest{
	OrderPage order;
	CheckoutPage checkOut;
    @Test
	public void performTest() throws InterruptedException{
	order = new OrderPage(driver);
	checkOut= order.placeOrder();
	checkOut.CheckOutOrder();
}
}
