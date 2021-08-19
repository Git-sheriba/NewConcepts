package practise;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PdfFileDownload {

	public static void main(String[] args) {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
      //  chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("download.default_directory", "D:\\downloads");
     //   chromePrefs.put("safebrowsing.enabled", "false");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
       
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(options);
		
		
		
		driver.get("https://www.guru99.com/java-tutorial-pdf.html");
		
		driver.findElement(By.xpath("(//img[@class='myad'])[2]")).click();
		

	}

}
