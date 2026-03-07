package week5.day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");

		// Search oneplus 9 pro
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro", Keys.ENTER);

		// Get the price of the first product
		WebElement price = driver.findElement(By.xpath("//span[@class='a-price'][1]"));
		String phonePrice = price.getText();
		System.out.println("The price of first phone :" + phonePrice);

		// Print customer Ratings
		WebElement rating = driver.findElement(By.xpath("//div[@class='a-row a-size-small'][1]"));
		String cusRating = rating.getText();
		System.out.println("The cusromer Rating is:" + cusRating);

		// Click first text link
		driver.findElement(By.xpath(
				"(//a[@class='a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal'])[1]"))
				.click();

		// Switch to Child Window
		Set<String> childWindow = driver.getWindowHandles();
		System.out.println(childWindow);

		List<String> currentactiveWindow = new ArrayList<String>(childWindow);

		driver.switchTo().window(currentactiveWindow.get(1));
		Thread.sleep(3000);

		// Take screenshot
		File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Click on Add to cart
		File target = new File("./data/s31.png");
		FileUtils.copyFile(screenshotAs, target);
		Thread.sleep(3000);
		//click add to cart
		WebElement addToCart=driver.findElement(By.xpath("//div[@id='newAccordionRow_0']//input[@id='add-to-cart-button']"));
		Actions act = new Actions(driver);
		act.scrollToElement(addToCart).perform();
		addToCart.click();
		Thread.sleep(3000);
		// Find the count in cart
		WebElement addtocart = driver.findElement(By.xpath("//span[@id='nav-cart-count']"));
		String cartCount = addtocart.getText();
		System.out.println("Cart count :" + cartCount);
		driver.close();
	}

}
