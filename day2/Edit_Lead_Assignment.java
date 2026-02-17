package week3.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Edit_Lead_Assignment {

	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(opt);

		driver.get(" http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.id("label")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("//span[text()='Company Name']/following::input[1]")).sendKeys("Test leaf");

		driver.findElement(By.xpath("//span[text()='First name']/following::input[1]")).sendKeys("dhivya");
		driver.findElement(By.xpath("//span[text()='Last name']/following::input[1]")).sendKeys("subramanian");
		driver.findElement(By.xpath("//span[text()='First Name (Local)']/following::input[1]")).sendKeys("dhi");
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("CSE");
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("This is the description box");
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("dhivya246@gmail.com");

		WebElement dropDownelement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select opt1 = new Select(dropDownelement);
		opt1.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.partialLinkText("Edit")).click();
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).clear();
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_importantNote']")).sendKeys("This is an important note");
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
	
		String pageName=driver.getTitle();
	    System.out.println("The page title is:"+pageName);
	    driver.close();
	}

}
