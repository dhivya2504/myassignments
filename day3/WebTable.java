package week5.day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://finance.yahoo.com/");
		driver.findElement(By.linkText("Markets")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Crypto")).click();
		Thread.sleep(3000);
		List<WebElement> currencyname=driver.findElements(By.xpath(
			    "//div[contains(@class,'table-container')]//td[2]"));
		List<String> currencylist = new ArrayList<String>();
		for (int i = 1; i < currencyname.size(); i++) {
			String currency = currencyname.get(i).getText();
			System.out.println(currency);
			currencylist.add(currency);
	}

}
}
