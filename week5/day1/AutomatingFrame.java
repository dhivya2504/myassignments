package week5.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomatingFrame {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame(0);
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert1 = driver.switchTo().alert();
		// System.out.println(alert1.getText());
		String alert = alert1.getText();
	
		if (alert.contains("Please enter your name:")) {
			System.out.println("The prompt text passed");

		} else {
			System.out.println("prompt text failed");
		}
		alert1.accept();
	}

}
