package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selenium_Jenkins_Integration {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://google.com");
	}
	
	@Test
	public void test(){
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("porsche"+Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("porsche"));
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
