package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsBasicDemo {

	static WebDriver driver = null;

	//private static final String CODE1 = "{\n    \"theme\": \"standard\",\n    \"encoding\": \"utf-8\n}";
	//private static final String CODE2 = "{\n    \"protocol\": \"HTTPS\",\n    \"timelineEnabled\": false\n}";

	public static void main(String[] args) throws ClassNotFoundException {
		// create ExtentReports and attach repporter(s)

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
		extent.attachReporter(spark);
		

		extent.createTest("Google Search Test One", "this is a test to validate google search functionality");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		extent.createTest("Google Search Test One").log(Status.INFO, "Starting Test Case").pass("Navigated to google.com").pass("Entered text in Searchbox").pass("Pressed keyboard enter key").pass("Closed the browser").info("Test Completed");
		
		driver.get("https://google.com");
		
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("L2AGLb")).click();
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		
		driver.findElement(By.name("btnK")).click();
		
		driver.close();		
		driver.quit();
		
		
		ExtentReports extent1 = new ExtentReports();
		extent.attachReporter(spark);
		extent1.createTest("Google Search Test Two", "this is a test to validate google search functionality");
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		extent1.createTest("Google Search Test Two").log(Status.INFO, "Starting Test Case").pass("Navigated to google.com").pass("Entered text in Searchbox").fail("Pressed keyboard enter key").pass("Closed the browser").info("Test Completed");
		
		driver.get("https://google.com");
		
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("L2AGLb")).click();
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		
		driver.findElement(By.name("btnK")).click();
		
		driver.close();		
		driver.quit();
		
		extent.flush();

//		extent.createTest("").info("info").pass("pass").warning("warn").skip("skip").fail("fail");
//
//		extent.createTest("CodeBlock").generateLog(Status.PASS, MarkupHelper.createCodeBlock(CODE1, CODE2));
//
//		extent.createTest("ParentWithChild").createNode("Child")
//				.pass("This test is created as a toggle as part of a child test of 'ParentWithChild'");
//
//		extent.createTest("Tags").assignCategory("MyTag")
//				.pass("The test 'Tags' was assigned by the tag <span class='badge badge-primary'>MyTag</span>");
//
//		extent.createTest("Authors").assignAuthor("TheAuthor")
//				.pass("This test 'Authors' was assigned by a special kind of author tag.");
//
//		extent.createTest("Devices").assignDevice("TheDevice")
//				.pass("This test 'Devices' was assigned by a special kind of devices tag.");
//
//		extent.createTest("Exception! <i class='fa fa-frown-o'></i>")
//				.fail(new RuntimeException("A runtime exception occurred!"));
//
		
	}
}