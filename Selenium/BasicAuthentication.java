package practise;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasicAuthentication {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./MultiPass-for-HTTP-basic-authentication.crx"));
		new DesiredCapabilities();
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WIN10);
		options.merge(dc);

		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.30:5566/wd/hub"), options);

		String URL = "chrome-extension://enhldmjbphoeibbpdhmjkchohnidgnah/options.html";
		driver.get(URL);

		driver.findElement(By.id("url")).sendKeys(".*.the-internet.herokuapp.com/basic_auth");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();

		driver.get("http://the-internet.herokuapp.com/basic_auth");

	}

}
