package com.build.checkout;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	WebDriver driver=null;

	@FindBy(id=CheckoutConstants.FIRST_NAME)
	private WebElement firstName;
	@FindBy(id=CheckoutConstants.LAST_NAME)
	private WebElement lastName;
	@FindBy(id=CheckoutConstants.SHIPPING_ADDRESS)
	private WebElement address;
	@FindBy(id=CheckoutConstants.SHIPPING_POSTAL)
	private WebElement postal;
	@FindBy(id=CheckoutConstants.SHIPPING_CITY)
	private WebElement city;
	@FindBy(id=CheckoutConstants.SHIPPING_STATE)
	private WebElement state;
	@FindBy(id=CheckoutConstants.SHIPPING_PHONE)
	private WebElement phone;
	@FindBy(id=CheckoutConstants.EMAIL)
	private WebElement email;
	@FindBy(id=CheckoutConstants.CREDIT_CARD)
	private WebElement creditCard;
	@FindBy(id=CheckoutConstants.CREDIT_CARD_MONTH)
	private WebElement creditCardMonth;
	@FindBy(id=CheckoutConstants.CREDIT_CARD_YEAR)
	private WebElement creditCardYear;
	@FindBy(id=CheckoutConstants.CREDIT_CARD_NAME)
	private WebElement creditCardName;
	@FindBy(id=CheckoutConstants.CREDIT_CARD_CVV)
	private WebElement creditCardCVV;
	@FindBy(xpath=CheckoutConstants.REVIEW_ORDER)
	private WebElement reviewOrder;
	@FindBy(id=CheckoutConstants.TAX_AMOUNT)
	private WebElement taxAmount;
	public CheckoutPage(WebDriver driver){
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	}
	public void CheckOutOrder() throws InterruptedException{
		firstName.sendKeys("Shriram");
		lastName.sendKeys("Suryanarayanan");
		address.sendKeys("123 XYZ Street");
		postal.sendKeys("95050");
		city.sendKeys("Santa Clara");
		Select select = new Select(state);
		select.selectByVisibleText("California");
		phone.sendKeys("6692386123");
		email.sendKeys("shriram0205@gmail.com");
		creditCard.sendKeys("4111111111111111");
		Select select1 = new Select(creditCardMonth);
		select1.selectByVisibleText("12");
		Select select2 = new Select(creditCardYear);
		select2.selectByVisibleText("2017");
		creditCardName.sendKeys("Shriram Suryanarayanan");
		creditCardCVV.sendKeys("000");
		reviewOrder.click();
		Thread.sleep(2000);
		String value=taxAmount.getText();
		assertThat(value).isEqualTo("$115.66");		
		
	}

}
