package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Create new account")).click();
		driver.findElement(By.name("firstname")).sendKeys("dhivya555");
		driver.findElement(By.name("lastname")).sendKeys("subramanian");
		driver.findElement(By.name("reg_email__")).sendKeys("dhivya@34.com");
		driver.findElement(By.id("password_step_input")).sendKeys("dhivya@34");

		WebElement dropDownelement = driver.findElement(By.id("day"));
		Select opt1 = new Select(dropDownelement);
		opt1.selectByVisibleText("25");

		WebElement dropDownelement1 = driver.findElement(By.id("month"));
		Select opt2 = new Select(dropDownelement1);
		opt2.selectByVisibleText("Apr");

		WebElement dropDownelement2 = driver.findElement(By.id("year"));
		Select opt3 = new Select(dropDownelement2);

		opt3.selectByVisibleText("1989");

		driver.findElement(By.className("_58mt")).click();
	}

}
