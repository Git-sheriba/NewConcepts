package practise;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class FileDownload {

	public static void main(String[] args) {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		//chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", "D:\\downloads");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElementByLinkText("some-file.txt").click();

	}

}
