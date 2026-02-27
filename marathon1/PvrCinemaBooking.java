package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PvrCinemaBooking {

	public static void main(String[] args) throws InterruptedException {
		// Initiate chrome driver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch the browser
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// select location as chennai
		driver.findElement(By.xpath("//span[@id='city']/input")).sendKeys("Chennai");
		// Thread.sleep(3000);

		driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		// click cinema
		WebElement cinima = driver.findElement(By.xpath("//span[text()='Cinema']"));
		driver.executeScript("arguments[0].click();", cinima);

		// select Theater in dropdown,date and moviename

		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
		driver.findElement(By.xpath("//span[text()='INOX The Marina Mall, OMR, Chennai']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Tomorrow']")).click();

		driver.findElement(By.xpath("//span[text()='SOODHU KAVVUM (RE RELEASE)']")).click();
		driver.findElement(By.xpath("//span[text()='03:40 PM']")).click();
		driver.findElement(By.xpath("//button[@class='p-button p-component sc-hjsuWn kDwaXw bgColor filter-btn']"))
				.click();
		Thread.sleep(3000);

		// Accept terms
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		Thread.sleep(3000);

		// select seat

		driver.findElement(By.xpath("//span[@id='CL.CLUB|I:10']")).click();
		Thread.sleep(3000);
		// click proceed
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(3000);
		// get seat and total info

		String seatno = driver.findElement(By.xpath("//div[@class='seat-number']")).getText();

		String gratot = driver.findElement(By.xpath("//h6[text()='Grand Total']")).getText();
		System.out.println("The seat number and grand toatal:" + seatno + gratot);
		// click continue

		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		Thread.sleep(3000);
		String titl = driver.getTitle();
		System.out.println(titl);
	}

}
