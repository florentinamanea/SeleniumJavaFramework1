package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPageObjects {
	WebDriver driver = null;
	
	By textbox_search = By.name("q");
	By button_search = By.name("btnK");
	
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void maxPage() {
		driver.manage().window().maximize();
	}
	
	public void clickButtonCookies() {
		WebElement button = driver.findElement(By.id("L2AGLb"));
		button.click();
	}
	
	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		driver.findElement(button_search).click();
	}
}
