package week6.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Test
public class SalesForce {
	@DataProvider(name = "getvalue")
	public String[][] fetchData() {
		 //'Salesforce Automation by *Your Name*'
		String[][] data = new String[2][3];
		
	}	
	
	@Test(dataProvider = "getvalue")
	public void createLegalEntity((String Name) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\SeleniumProfile");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
		//Login to https://login.salesforce.com
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		//Click View All and click Legal Entities from App Launcher
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='App Launcher']"))).click();
		driver.findElement(By.xpath("//input[@type='search' and @role='combobox']")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//input[@type='search' and @role='combobox']")).sendKeys(Keys.ENTER);

		//Click on New Legal Entity
		driver.findElement(By.xpath("//li[.//div[@title='New']]")).click();
	
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(entityName);
	}


