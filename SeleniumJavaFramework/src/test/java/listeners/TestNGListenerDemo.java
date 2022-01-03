package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNGListenerDemo {
	
	@Test
	public void test1() {
		System.out.println("I am inside Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside Test2");
	
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com/");
		driver.manage().window().maximize();
		
		WebElement button = driver.findElement(By.id("L2AGLb"));
		button.click();
		WebElement textBox = driver.findElement(By.name("q"));
		textBox.sendKeys("Automatio Step by Step");
		
		driver.close();
		
	}
	
	@Test
	public void test3() {
		System.out.println("I am inside Test3");
		throw new SkipException("This test is skipped");
	}
	
}
