package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lead_Assignment {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get(" http://leaftaps.com/opentaps/");
		driver.manage().window().maximize(); 
		driver.findElement(By.id("username")).sendKeys("DemoCSR2");
	    driver.findElement(By.id("password")).sendKeys("crmsfa");
	    driver.findElement(By.className("decorativeSubmit")).click();
	    driver.findElement(By.id("label")).click();
	    driver.findElement(By.linkText("Leads")).click();
	    driver.findElement(By.linkText("Create Lead")).click();
	    driver.findElement(By.id("createLeadForm_firstName")).sendKeys("dhivya");
	    driver.findElement(By.id("createLeadForm_lastName")).sendKeys("subramanian");
	    driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
	    driver.findElement(By.name("generalProfTitle")).sendKeys("This is a title");
	    driver.findElement(By.className("smallSubmit")).click();
	    driver.close();
	}

}
