package week4_day2_assignments;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;

public class action_Nyka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'brands')]")));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		act.moveToElement(driver.findElement(By.xpath("//input[@id='brandSearchBox']"))).click().sendKeys("L\'Oreal Paris");
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(), 'Oreal Paris')][1]"))).click();
		act.build().perform();
		
		String title = driver.findElement(By.xpath("//div[@id='title']")).getText();
		if (title.contains("L'Oreal Paris"))
		{
			System.out.println("Loreal product is selected");
		}
		
		//scroll down using JS
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		
		//Sort by actions.
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text(), 'customer top rated']")).click();
		driver.findElement(By.xpath("//span[contains(text(), 'Hair')]")).click();
		driver.findElement(By.xpath("//span[contains(text(), 'Hair Care')]")).click();
		driver.findElement(By.xpath("//span[contains(text(), 'Shampoo')]")).click();
		
		
		
		
	}

}
