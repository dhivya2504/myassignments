package week6.day1;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProjectSpecificSalesForceMethods {
	ChromeDriver driver;
	
	@Parameters({ "url", "userName", "passWord" })
	@BeforeMethod
	public void sales(String url, String uName, String pWord) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\SeleniumProfile");
		options.addArguments("--disable-notifications");
	    driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pWord);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
	}

}
