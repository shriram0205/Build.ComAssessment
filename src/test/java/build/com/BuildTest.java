package build.com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class BuildTest {
	public WebDriver driver;
	public String appURL="https://www.build.com";
	
	
  @Test
  public void buildTest() throws InterruptedException {
	  driver.get(appURL);
      Thread.sleep(2000);
	  driver.findElement(By.id("search_txt")).sendKeys("Suede Kohler K-6626- 6U");
	  driver.findElement(By.xpath("//button[@class='button-primary search-site-search']")).click();
	  driver.findElement(By.xpath(".//*[@id='product-composite-563763']/div[2]/a/div[1]/img")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(".//*[@id='configure-product-wrap']/button")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.id("search_txt")).sendKeys("Cashmere Kohler K-6626- 6U");
	  driver.findElement(By.xpath("//button[@class='button-primary search-site-search']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='product-composite-563763']/div[2]/a/div[1]/img")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='configure-product-wrap']/button")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("search_txt")).sendKeys("Kohler K-5180- ST");
	  driver.findElement(By.xpath("//button[@class='button-primary search-site-search']")).click();
	  Thread.sleep(2000);
	  WebElement toClear=driver.findElement(By.xpath(".//*[@id='main-product-quantity']/div/input"));
	  toClear.sendKeys(Keys.CONTROL + "a");
	  toClear.sendKeys(Keys.DELETE);
	  driver.findElement(By.xpath("//input[@name='qty']")).sendKeys("2");
	  driver.findElement(By.xpath(".//*[@id='add-to-cart-wrap']/button")).click();
	  Thread.sleep(2000);
	  String value = driver.findElement(By.id("cart-grand-total")).getText();
	  assertThat(value).isEqualTo("$1,595.18");
	  driver.findElement(By.linkText("Secure Checkout")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='guest-login']/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("shippingfirstname")).sendKeys("Shriram");
	  driver.findElement(By.id("shippinglastname")).sendKeys("Suryanarayanan");
	  driver.findElement(By.id("shippingaddress1")).sendKeys("123 XYZ Street");
	  driver.findElement(By.id("shippingpostalcode")).sendKeys("95050");
	  driver.findElement(By.id("shippingcity")).sendKeys("Santa Clara");
	  Select select = new Select(driver.findElement(By.id("shippingstate_1")));
	  select.selectByVisibleText("California");
	  driver.findElement(By.id("shippingphonenumber")).sendKeys("6692386123");
	  driver.findElement(By.id("emailAddress")).sendKeys("shriram0205@gmail.com");
	  driver.findElement(By.id("creditCardNumber")).sendKeys("4111111111111111");
	  Select select1 = new Select(driver.findElement(By.id("creditCardMonth")));
	  select1.selectByVisibleText("12");
	  Select select2 = new Select(driver.findElement(By.id("creditCardYear")));
	  select2.selectByVisibleText("2017");
	  driver.findElement(By.id("creditcardname")).sendKeys("Shriram Suryanarayanan");
	  driver.findElement(By.id("creditCardCVV2")).sendKeys("000");
	  driver.findElement(By.xpath("//input[@value='Review Order']")).click();
	  Thread.sleep(2000);
	  String value1 = driver.findElement(By.id("taxAmount")).getText();
	  assertThat(value1).isEqualTo("$115.66");	  
	  
  }
    @Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(@Optional("Firefox")String browser) throws InterruptedException {
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				  ChromeOptions options = new ChromeOptions();
				  options.addArguments("--disable-notifications");
				  System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
				  
					driver =new ChromeDriver(options);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("https://www.build.com");
					WebElement element=driver.findElement(By.id("newsletter-modal"));
					element.sendKeys(Keys.SPACE);
					Thread.sleep(2000);
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

  @AfterTest
  public void tearDown() {
	  driver.close();
  }

}
