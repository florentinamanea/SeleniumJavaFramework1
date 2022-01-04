package demo;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStackDemo {
	public static final String AUTOMATE_USERNAME = "florentinamanea_VrGQgH";
	  public static final String AUTOMATE_ACCESS_KEY = "8ZBdo3zNvpqmzaySAo3m";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  
	  public static void main(String[] args) throws Exception {
		  DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("os", "Windows");
		  caps.setCapability("os_version", "10");
		  caps.setCapability("browser", "Chrome");
		  caps.setCapability("browser_version", "latest");
		  caps.setCapability("project", "Test");
		  caps.setCapability("build", "Build1");
		  caps.setCapability("name", "Test1");
		  caps.setCapability("browserstack.local", "false");
		  caps.setCapability("browserstack.debug", "true");
		  caps.setCapability("browserstack.networkLogs", "true");
		  caps.setCapability("browserstack.selenium_version", "3.14.0");
	    
	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("https://google.com");
	    driver.findElement(By.id("L2AGLb")).click();
	    WebElement googleSearchBox = driver.findElement(By.name("q"));
	    googleSearchBox.sendKeys("BrowserStack");
	    googleSearchBox.submit();
	    
	    System.out.println(driver.getTitle());
	    driver.quit();
	  }
}
