import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class MyWebStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean hasNextPage = true;
		int btnNext = -1;

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.webstaurantstore.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("searchval")).sendKeys("stainless work table");
		driver.findElement(By.xpath("//button[text()='Search']")).click();

		int pageNum = 1;
		String txtSearch = "";
		List<WebElement> productList = null;
		while (hasNextPage) {
			System.out.println("Page Number is : " + pageNum);
			productList = driver
					.findElements(By.xpath("//div[@id='product_listing']//a[@data-testid='itemDescription']"));

			for (int i = 0; i < productList.size(); i++) {
				System.out.println(productList.get(i).getText());
				txtSearch = productList.get(i).getText();

				if (!txtSearch.contains("Table")) {
					System.out.println("************No such text Table in it ************");
				}
			}

			// Logic to click the next page buttons
			List<WebElement> enabled_next_page_btn = driver
					.findElements(By.xpath("//li[@class='rc-pagination-next'][@aria-disabled='false']"));
			List<WebElement> enabled_next_page_btn_click = driver
					.findElements(By.xpath("//li[@class='rc-pagination-next']"));
			if (enabled_next_page_btn.size() > 0) {
				btnNext++;
				enabled_next_page_btn_click.get(0).click();
				btnNext--;
				hasNextPage = true;
			} else {
				// System.out.println(addlastitem.get(0).getText());
				System.out.println("No more Pages Available");
				hasNextPage = false;
			}
			pageNum++;
		}
		// out of while loop ( Means we are done with all the 9 pages)
		// This size gives the size of the list that was recently updated.
		// So, it should be the list of the last page ( ie Last page 9 - size is 60 --
		// MEans the last item is at the 60th position. )
		// SO, choosing the product with this size as the index will surely be the last element of the last page
		// This can be added to the cart.
		
		System.out.println("productList.size()" + productList.size());
		// click "AddToCart" of the last element of the last page
		driver.findElement(By.xpath("(//div[@class='add-to-cart'])[" + productList.size() + "]")).click();

		// Click the Add to Cart of the pop up
		driver.findElement(By.xpath("//button[text()='Add To Cart']")).click();

		
		
		// NOT YET DONE- THROWS EXCEPTION
		// driver.findElement(By.xpath("//button[text()='×']")).click();

		// Click the Cart button
		// driver.findElement(By.xpath("//span[text()='Cart']")).click();

	}

}
