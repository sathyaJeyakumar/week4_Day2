//after clicking add to cart, it is displaying cart but price is not showing in it.
package week4_day2_assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class action_amazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//L (https://www.amazon.in/)
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//1. Get price of first product
		String nPrice = driver.findElement(By.xpath("//span[@class='a-price'][1]")).getText();
		System.out.println("PRice of first displayed mobile : "+nPrice.replaceAll("[\\-\\+\\.\\^:,]",""));
		
		// 2. Get rating of first mobile
		String nRating = driver.findElement(By.xpath("//div[@class='a-row a-size-small'][1]")).getText();
		System.out.println("First Rating: "+ nRating);
		
		//3. First link text of first mobile.
		driver.findElement(By.xpath("//span[@class =\"a-size-medium a-color-base a-text-normal\"][1]")).click();
		
		//it opens in new window
		Set<String> windows = driver.getWindowHandles();
		
		List<String> allwindow=new ArrayList<String>(windows);
		driver.switchTo().window(allwindow.get(1));
		System.out.println(allwindow.get(1));
		//4. take screenshot of the page
		
		TakesScreenshot phonescr = ((TakesScreenshot)driver);
		
		File srcFile = phonescr.getScreenshotAs(OutputType.FILE);
		
		File DestFile=new File("C://Users//dell//Downloads//actionAmazonPhone.png");
			
		 
		 try {
			FileUtils.copyFile(srcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 //scroll down to element using java script
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		 js.executeScript("arguments[0].click();", driver.findElements(By.xpath("//input[@id ='add-to-cart-button'][1]")).get(1));
		
		 //get price of mobile from product description page and compare against nPrice
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 String nProductPrice = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getAttribute("outerText");
		 String nArrayProductPrice = nProductPrice;
		 System.out.println("Product price is -----> "+ nArrayProductPrice.split("\\.")[0]);
		
		 if(nPrice.equals(nProductPrice.replaceAll("(?<=\\d),(?=\\d)", "")))
		 {
			 System.out.println("Same price... Verified!");
		 }
		 
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
//		 String nCartAmount = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
//		 System.out.println("ncart amount "+ nCartAmount);
//		 driver.quit();
	}

}
