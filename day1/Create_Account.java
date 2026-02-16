package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Create_Account {

	public static void main(String[] args) {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(opt);

		driver.get(" http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR2");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.id("label")).click();
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys("dhivya5545");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");

		WebElement dropDownelement4 = driver.findElement(By.name("industryEnumId"));
		Select opt6 = new Select(dropDownelement4);
		opt6.selectByVisibleText("Computer Software");

		WebElement dropDownelement = driver.findElement(By.name("ownershipEnumId"));
		Select opt1 = new Select(dropDownelement);
		opt1.selectByVisibleText("S-Corporation");

		WebElement dropDownelement1 = driver.findElement(By.name("dataSourceId"));
		Select opt2 = new Select(dropDownelement1);
		opt2.selectByVisibleText("Employee");

		WebElement dropDownelement2 = driver.findElement(By.id("marketingCampaignId"));
		Select opt3 = new Select(dropDownelement1);
		opt3.selectByIndex(6);

		WebElement dropDownelement3 = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select opt4 = new Select(dropDownelement3);
		opt4.selectByValue("TX");
		driver.findElement(By.className("smallSubmit")).click();

		driver.close();
	}

}
