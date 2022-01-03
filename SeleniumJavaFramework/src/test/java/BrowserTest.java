import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
	public static void main(String[] args) {
		
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
		
		
		//driver.close();
		//driver.quit();
		
	}
}
