package build.com;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidBaseTest {
	protected AndroidDriver<AndroidElement> driver;
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
