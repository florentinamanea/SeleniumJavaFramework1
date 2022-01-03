package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNG_Demo {
	private static WebDriver driver = null;
	public static String browserName=null;
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/firefoxdriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
//		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
//		driver = new ChromeDriver();
	}
	
	@Test
	public static void googleSearch() {	
		//goto google.com
		driver.get("https://google.com");
		driver.manage().window().maximize();
		
		WebElement button = driver.findElement(By.id("L2AGLb"));
		button.click();
		
		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		
		//click on search button
		driver.findElement(By.name("btnK")).click();
	}
	
	@AfterTest
	public void tearDownTest() {
		//close browser
				driver.close();
				//driver.quit();
				System.out.println("Test Completed Successfully");
				PropertiesFile.setProperties();
	}
 }
