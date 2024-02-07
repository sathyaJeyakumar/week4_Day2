package week4_day2_assignments;

import org.openqa.selenium.chrome.ChromeDriver;

public class w3schools {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
			driver.manage().window().maximize();
			
	}

}
