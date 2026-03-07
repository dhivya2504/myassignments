package week5.day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(" https://www.bigbasket.com/");
		driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:Ramkj6:']")).click();

		// mouse over foodgrains
		WebElement foodgrains = driver.findElement(
				By.xpath("//div[@id='headlessui-menu-items-:Rimkj6:']//li/a[text()='Foodgrains, Oil & Masala']"));
		Actions act = new Actions(driver);
		act.moveToElement(foodgrains).perform();

		// mouse over rice and rice products
		WebElement riceproducts = driver.findElement(
				By.xpath("//div[@id='headlessui-menu-items-:Rimkj6:']//li/a[text()='Rice & Rice Products']"));
		act.moveToElement(riceproducts).perform();
		driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")).click();
		driver.findElement(By.xpath("//input[@id='i-bbRoyal']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']")).click();

		Set<String> childWindow = driver.getWindowHandles();
		System.out.println(childWindow);

		List<String> currentWindow = new ArrayList<String>(childWindow);

		driver.switchTo().window(currentWindow.get(1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='flex justify-start w-full h-full']//span[text()='5 kg']")).click();

		WebElement RicePrice = driver.findElement(By.xpath("//td[@class='Description___StyledTd-sc-82a36a-0 hueIJn']"));
		String text = RicePrice.getText();
		System.out.println("Price of the Rice is " + text);

		driver.findElement(By.xpath("//div/button[text()='Add to basket'][1]")).click();

		WebElement message = driver.findElement(By.xpath("//p[@class='mx-4 flex-1']"));
		String verify=message.getText();
		System.out.println("Verification message :"+verify);
		Thread.sleep(3000);
		
		File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File target = new File("./bigbasket/Snap.png");
		FileUtils.copyFile(screenshotAs, target);
		Thread.sleep(3000);
		
         driver.close();
		
		driver.switchTo().window(currentWindow.get(0));
		
		driver.close();
	}
}
