package week6.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicParameterization extends ProjectSpecifiedMethod{
	
	
	@BeforeClass
	public void setData() {
		fileName = "LegalNames";
	}
	@Test(dataProvider = "getvalue")
	public void salesforce(String name)
	{
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
		WebElement scrollTo = driver.findElement(By.xpath("//p[contains(text(),'Legal Entities')]"));
		Actions act = new Actions(driver);
		act.scrollToElement(scrollTo).perform();
		scrollTo.click();
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(name);
		driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
	}
}