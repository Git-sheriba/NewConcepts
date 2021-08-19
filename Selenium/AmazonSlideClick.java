package research;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSlideClick {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());

		WebElement imageEle = driver.findElementByXPath("//li[@class='a-carousel-card' and @aria-hidden='false']//img[@alt='FabPhones']");

		driver.executeScript("arguments[0].click();", imageEle);
		System.out.println(driver.getTitle());
		driver.quit();

	}	

}
