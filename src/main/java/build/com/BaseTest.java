package build.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest 
{
	protected WebDriver driver =null;
	@Parameters({ "browser" })
	@BeforeTest
	public void setup(@Optional("Firefox")String browser) throws InterruptedException{
		    
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("https://www.build.com");
				
				
				
			} else if (browser.equalsIgnoreCase("chrome")) {
				  System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
				    driver =new ChromeDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("https://www.build.com");

			}else{
			  {
				  System.setProperty("webdriver.ie.driver", "C:/IEDriverServer.exe");
				    driver =new InternetExplorerDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get("https://www.build.com");

			}
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}
	@AfterTest
	  public void teardown(){
		  driver.close();
	  }
}
