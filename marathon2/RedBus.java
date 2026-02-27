package marathon2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		// Launching the browser
		ChromeDriver driver = new ChromeDriver();
		// maximize
		driver.manage().window().maximize();
		// Navigate to redbus
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// from
		driver.findElement(By.xpath("//input[@id='srcinput']")).sendKeys("Periyar Bus Stand");
		driver.findElement(By.xpath("//div[text()='Periyar Bus Stand']")).click();

		// To
		driver.findElement(By.xpath("//input[@id='destinput']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();

		// Date
		driver.findElement(By.xpath("//button[text()='Tomorrow']")).click();
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//button[text()='Search buses']")).click();
		// Total no of bus
		String bus = driver.findElement(By.xpath("//div[contains(@class,'busesFoundText')]")).getText();
		System.out.println("Total count of bus : " + bus);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'AC')][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'High Rated Buses')]")).click();
		String highratedac = driver.findElement(By.xpath("//div[contains(@class,'busesFoundText')]")).getText();
		System.out.println("Total HighratedAC bus count : " + highratedac);
		List<WebElement> lowprice = driver.findElements(By.xpath("//p[contains(@class,'finalFare')]"));
		List<Integer> busprice = new ArrayList<>();

		for (WebElement l : lowprice) {
			int bprice = Integer.parseInt(l.getText().replaceAll("[^0-9]", ""));
			busprice.add(bprice);
		}
		Collections.sort(busprice);
		Thread.sleep(3000);
		System.out.println("Lowest bus price is:"+busprice.get(0));
		System.out.println("The current page title is=" + driver.getTitle());
	}

}
