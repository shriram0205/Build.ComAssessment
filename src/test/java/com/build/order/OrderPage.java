package com.build.order;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.build.checkout.CheckoutPage;


public class OrderPage {
	WebDriver driver=null;
	@FindBy(xpath=OrderConstants.POPUP)
	private WebElement popup;
	@FindBy(id=OrderConstants.SEARCH_TXT)
	private WebElement searchText;
	@FindBy(xpath=OrderConstants.SEARCH_BUTTON)
	private WebElement searchButton;
	@FindBy(xpath=OrderConstants.SUEDE_KOHLER)
	private WebElement suedeKohler;
	@FindBy(xpath=OrderConstants.ADD_CART1)
	private WebElement addCart1;
	@FindBy(xpath=OrderConstants.CASHMERE_KOHLER)
	private WebElement cashmereKohler;
	@FindBy(xpath=OrderConstants.INPUT_CLEAR)
	private WebElement inputClear;
	@FindBy(xpath=OrderConstants.QUANTITY)
	private WebElement quantity;
	@FindBy(xpath=OrderConstants.FINAL_ADD_CART)
	private WebElement finalAddCart;
	@FindBy(id=OrderConstants.GRAND_TOTAL)
	private WebElement grandTotal;
	@FindBy(linkText=OrderConstants.SECURE_CHECKOUT)
	private WebElement secureCheckout;
	@FindBy(xpath=OrderConstants.GUEST_LOGIN)
	private WebElement guestLogin;
	
	public OrderPage(WebDriver driver){
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	}
	
	public CheckoutPage placeOrder() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    WebDriverWait wait = new WebDriverWait(driver,15);
		WebElement popup1= wait.until(ExpectedConditions.visibilityOf(popup));
		popup1.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		searchText.sendKeys("Suede Kohler K-6626- 6U");
		searchButton.click();
		Thread.sleep(4000);
		suedeKohler.click();
		Thread.sleep(1000);
		addCart1.click();
		Thread.sleep(2000);
		searchText.sendKeys("Cashmere Kohler K-6626- 6U");
		searchButton.click();
		Thread.sleep(2000);
		cashmereKohler.click();
		Thread.sleep(1000);
		addCart1.click();
		searchText.sendKeys("Kohler K-5180- ST");
		searchButton.click();
		Thread.sleep(2000);
		inputClear.sendKeys(Keys.CONTROL + "a");
		inputClear.sendKeys(Keys.DELETE);
		quantity.sendKeys("2");
		finalAddCart.click();
		Thread.sleep(2000);
        String value=grandTotal.getText();
		assertThat(value).isEqualTo("$1,595.18");
		Thread.sleep(2000);
		secureCheckout.click();
		Thread.sleep(2000);
		guestLogin.click();
		Thread.sleep(2000);
		return new CheckoutPage(driver);
	}
	  

}
