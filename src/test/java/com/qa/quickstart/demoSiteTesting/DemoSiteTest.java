package com.qa.quickstart.demoSiteTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.qa.quickstart.demoSiteTesting.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoSiteTest {
	static ExtentReports extent;
	static ExtentTest test;
	
	@BeforeClass
	public static void reportBuilder() {
	extent =new ExtentReports("C:\\Users\\Administrator\\Documents\\.html",true);
	}
	
	WebDriver driver;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\eclipse-workspace\\SeleniumExamples-master\\WebDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	

	@Test
	public void Test1() {
		test = extent.startTest("Check Add User and Login Functionality");
		
		//Takes to Home Page
		driver.get(Constants.HomePage);
		
		//Clicks on Add a User
		driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click();
		test.log(LogStatus.INFO, "Opens Add User Page");
		
		//Enters saul into the username field
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")).sendKeys("saul");
		
		//Enters saul123 into the password field
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")).sendKeys("saul123");
		
		//Clicks on the save button
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();
		test.log(LogStatus.INFO, "Clicked Save Button");
		
		//Clicks on Login
		driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
		
		//Enters saul into the username field
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys("saul");
		
		//Enters saul123 into the password field
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")).sendKeys("saul123");
		
		//Clicks on the Test Login button
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click();
		test.log(LogStatus.INFO, "Clicked on Test Login Button");
		
		//Checks whether the login has been successful
		WebElement checkElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("**Successful Login**",checkElement.getText());
		test.log(LogStatus.PASS, "Add and Login User");
	}
	
	@After
	public void tearDown() {
	driver.close();
	}
	
	@AfterClass
	public static void flushReport() {
		extent.flush();
	}
	

}
