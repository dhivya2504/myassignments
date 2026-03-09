package week5.day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapDeal {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[text()=\"Men's Fashion\"]")).click();
		driver.findElement(
				By.xpath("//div[text()=\"Men's Fashion\"]/following-sibling::div//div[text()='Sports Shoes']")).click();

		String count = driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText();
		System.out.println(count);

		// click on training shoes
		driver.findElement(By.xpath("//a[div[text()='Training Shoes']]")).click();
		// sort
		driver.findElement(By.xpath("//div[contains(@class,'sort-drop')]")).click();
		driver.findElement(By.xpath("//ul[contains(@class,'sort-value')]//li[normalize-space()='Price Low To High']"))
				.click();

		// send price
		WebElement fromValue = driver.findElement(By.name("fromVal"));
		fromValue.clear();
		fromValue.sendKeys("300");
		WebElement toVal = driver.findElement(By.name("toVal"));
		toVal.clear();
		toVal.sendKeys("1800");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();
		// select color
		Actions act = new Actions(driver);
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement color = driver.findElement(By.xpath("//span[contains(@class,'filter-color-tile')]"));
		WebElement colourwait = explicitWait
				.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(color)));

		act.scrollToElement(colourwait).perform();
		colourwait.click();
		Thread.sleep(5000);
		// first result
		 WebElement FirstResultShoe =
		 driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		 act.moveToElement(FirstResultShoe).perform();
		// Click Quick VIew
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();

		// Print the Cost and Discount Price
		WebElement DiscountPrice = driver.findElement(By.xpath("//div[@class='lfloat']/div[2]"));
		String Price = DiscountPrice.getText();
		System.out.println("Price and Discount of the Product is " + Price);

		// Screenshot
		File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File target = new File("./data/Snap11.png");
		FileUtils.copyFile(screenshotAs, target);
		driver.quit();

		
	}

}
