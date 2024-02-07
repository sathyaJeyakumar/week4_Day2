package week4_day2_assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class snapDeal_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		
		//click on Men's fashion
		driver.findElement(By.xpath("//span[contains(text(), \"Men's Fashion\")]")).click();
		driver.findElement(By.xpath("//span[contains(text(), \"Sports Shoes\")][1]")).click();
		String ShoesCount = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Men's fashion has "+ ShoesCount);
		String nShoescount = (ShoesCount.split("\\(")[1]).split(" ")[1];
		System.out.println("total shoes in men's fashion : "+nShoescount);
		
		//click on Training shoes
		driver.findElement(By.xpath("//div[contains(text(), 'Training Shoes')]")).click();
		driver.findElement(By.xpath("//span[@class='sort-label']")).click();
		
		//6. Sort the products by "Low to High". 
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		////span[@class="lfloat product-price"]
		List <WebElement> ProductPrices = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		//String SortedFirstProductPrice = ProductPrices.get(0).getText();
		String SortedLAstElementPrice = ProductPrices.get(11).getText();
		System.out.println("Size of list-->"+ProductPrices.size());
		//System.out.println(SortedFirstProductPrice+ "Last-->"+SortedFirstProductPrice);
		System.out.println("Last-->"+SortedLAstElementPrice);
		//if IntegerSortedFirstProductPrice < SortedLAstElementPrice)
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (WebElement element : ProductPrices) {
		    System.out.println("Price List:" + element.getText());
		}
		
	}

}
