package week5.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandlingInteraction {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(opt);

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR2");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.id("label")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//td[span[text()='From Contact']]/following-sibling::td//a")).click();
		Set<String> childwindow1 = driver.getWindowHandles();
		//System.out.println(childwindow1);
		List<String> currentlyActiveWindows1 = new ArrayList<String>(childwindow1);
		driver.switchTo().window(currentlyActiveWindows1.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-body']//table//td[1]//a)[1]")).click();
		
		driver.switchTo().window(currentlyActiveWindows1.get(0));
		//click to contact
		driver.findElement(By.xpath("//td[span[text()='To Contact']]/following-sibling::td//a")).click();
		Set<String> childwindow2 = driver.getWindowHandles();
		//System.out.println(childwindow2);
		List<String> currentlyActiveWindows2 = new ArrayList<String>(childwindow2);
		driver.switchTo().window(currentlyActiveWindows2.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-body']//table//td[1]//a)[2]")).click();
		driver.switchTo().window(currentlyActiveWindows2.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		String title1 = driver.getTitle();
		System.out.println(title1);
		
		
	}

}
