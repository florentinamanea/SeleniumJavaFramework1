package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearch();
	}
	
	public static void googleSearch() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		//goto google.com
		driver.get("https://google.com");
		driver.manage().window().maximize();
		
		WebElement button = driver.findElement(By.id("L2AGLb"));
		button.click();
		
		//enter text in search textbox
		//driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step by Step");
		
		//click on search button
		//driver.findElement(By.name("btnK")).click();
		GoogleSearchPage.button_search(driver).click();
		
		//close browser
		driver.close();
		
		System.out.println("Test Completed Successfully");
	}
}
