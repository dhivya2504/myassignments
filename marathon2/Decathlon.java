package marathon2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Decathlon {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.decathlon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[@class='index-module_type__E-SaG']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Shoes For Men']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Running')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Men')]")).click();
		driver.findElement(By.xpath("//span[text()='Most Relevant']")).click();
		driver.findElement(By.xpath("//li[a[text()='Highest Discount']]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='swiper-slide swiper-slide-active'][1]")).click();
		Thread.sleep(5000);
		WebElement findElement = driver.findElement(By.xpath("//div[contains(text(),'8.5')]"));
		driver.executeScript("arguments[0].click();", findElement);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='ADD TO CART']")).click();
		String incart = driver.findElement(By.xpath("//a[@aria-label='cart']/div/div/div")).getText();
		int ifpresent=Integer.parseInt(incart);
		if (ifpresent>0) {
			System.out.println("No of Items in cart:" +ifpresent);
			
		}
		else {
			System.out.println("Items not added in the cart");
		}
			
		
	}
}
