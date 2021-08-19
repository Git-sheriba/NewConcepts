package practise;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;



public class HeadlessDownload {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("safebrowsing.enabled", "true");
		chromePrefs.put("downloadPath", "D:\\downloads"); 
		chromePrefs.put("behavior", "allow"); 
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		ChromeDriverService driverService = ChromeDriverService.createDefaultService();
		ChromeDriver driver = new ChromeDriver(driverService, options);
		
		
		Map<String, Object> commandParams = new HashMap<String, Object>();
		commandParams.put("cmd", "Page.setDownloadBehavior");
		commandParams.put("params", chromePrefs);

		ObjectMapper objectMapper = new ObjectMapper();
		HttpClient httpClient = HttpClientBuilder.create().build();

		String command = objectMapper.writeValueAsString(commandParams);
		String u = driverService.getUrl().toString() + "/session/" + ((RemoteWebDriver) driver).getSessionId() + "/chromium/send_command";

		HttpPost request = new HttpPost(u);
		request.addHeader("content-type", "application/json");
		request.setEntity(new StringEntity(command));
		httpClient.execute(request);
		
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElementByLinkText("some-file.txt").click();
		
		

	}

}
