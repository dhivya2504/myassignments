package marathon3;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TataCliq {

	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.tatacliq.com/");
		WebElement brands = driver.findElement(By.xpath("//div[text()='Brands']"));
		Actions act = new Actions(driver);
		act.moveToElement(brands).perform();
		driver.findElement(By.xpath("//div[text()='Watches & Accessories']")).click();
		driver.findElement(By.xpath("//div[@class='DesktopHeader__featureBrands']/div[2]")).click();
		WebElement newArrival = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select select = new Select(newArrival);

		select.selectByVisibleText("New Arrivals");
		driver.findElement(By.xpath("//div[text()='Men']")).click();
		
		String priceList = driver
				.findElement(By.xpath("//div[@class='ProductDescription__discount ProductDescription__priceHolder']")).getText();
		System.out.println("price of first watch" +priceList);
		List<WebElement>  watchPrice = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		
		List<Integer> priceListNumber = new ArrayList<Integer>();
		for (WebElement priceLoop : watchPrice) {
			String price = priceLoop.getText().replace("₹", "").replace(",", ""); // remove currency symbol and commas
			int priceInt = Integer.parseInt(price);
			System.out.println(priceInt);
			priceListNumber.add(priceInt);
		}
		
		driver.findElement(By.xpath("//div[@class='ProductModule__imageAndDescriptionWrapper']/ancestor::a")).click();

		Set<String> childWindow = driver.getWindowHandles();
		System.out.println(childWindow);

		List<String> currentWindow = new ArrayList<String>(childWindow);

		driver.switchTo().window(currentWindow.get(1));
		String childprice = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']//h3")).getText();
		
	System.out.println("Child price:"+childprice);
	if (priceList.equals(childprice)) {
		System.out.println("Both the prices are same");
	} else {
		System.out.println("Both the Prices are not matching");
	}
	//Add to cart
	driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
	
	String cartcount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
	
	//print no of items
	
	System.out.println("No of items added on the car "+cartcount);
	
	//Take screen schot
	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshot, new File("./pics/s1.png"));
	
	driver.switchTo().window(currentWindow.get(1)).close();
	
	
	
	}
	}


