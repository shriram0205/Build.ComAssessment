package build.com;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class AppiumTest {
	AndroidDriver<AndroidElement> driver;
  @Test
  public void androidTest() throws InterruptedException {
	  driver.get("https://www.build.com");
	  Thread.sleep(2000);
	  driver.findElementById("search_txt").sendKeys("Suede Kohler K-6626- 6U");
	  driver.findElementById("search_txt").sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  driver.findElementByXPath(".//*[@id='product-composite-563763']/a/div/div[2]/img").click();
	  Thread.sleep(2000);
	  driver.findElementByXPath("//div[@id='add-to-cart-wrap']").click();
	  Thread.sleep(2000);
	  driver.findElementById("search_txt").sendKeys("Cashmere Kohler K-6626- 6U");
	  driver.findElementById("search_txt").sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  driver.findElementByXPath(".//*[@id='product-composite-563759']/a/div/div[2]/img").click();
	  Thread.sleep(2000);
	  driver.findElementByXPath("//div[@id='add-to-cart-wrap']").click();
	  Thread.sleep(2000);
	  driver.findElementById("search_txt").sendKeys("Kohler K-5180- ST");
	  Thread.sleep(2000);
	  driver.findElementByXPath("//button[@title='Increment']").click();
	  driver.findElementByXPath("//div[@id='add-to-cart-wrap']").click();
	  Thread.sleep(2000);
	  String value= driver.findElementById("cart-grand-total").getText();
	  Assert.assertEquals("$1,595.18", value);
	  driver.findElementByXPath("//a[@href='/checkout/begin']").click();
	  Thread.sleep(2000);
	  driver.findElementByXPath("//button[@ data-loading-text='Checking out...']").click();
	  Thread.sleep(2000);
	  driver.findElementByName("address[email]").sendKeys("shriram0205@gmail.com");
	  driver.findElementByName("address[fullName]").sendKeys("Shriram Suryanarayanan");
	  driver.findElementByName("address[address]").sendKeys("123 XYZ Street");
	  driver.findElementByName("address[zip]").sendKeys("95050");
	  driver.findElementByName("address[city]").sendKeys("Santa Clara");
	  driver.findElementByName("address[phone]").sendKeys("6692386123");
	  driver.findElementByXPath("//button[@data-loading-text='Continuing to Payment...']").click();
	  Thread.sleep(2000);
	  driver.findElementById("cardNumber").sendKeys("4111111111111111");
	  driver.findElementByName("expiration").sendKeys("12/17");
	  driver.findElementByName("cvv").sendKeys("000");
	  driver.findElementByXPath("//button[@data-loading-text='Continuing to Review...']").click();
	  Thread.sleep(2000);
	  String value1= driver.findElementById("cart-tax-total").getText();
	  Assert.assertEquals("$115.66", value1);
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	  caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
	  driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
