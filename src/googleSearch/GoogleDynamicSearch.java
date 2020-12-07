package googleSearch;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class GoogleDynamicSearch {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(1000,TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("yasar hameed");
		
		List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbtc']"));
		System.out.println("The total Size of the List ====> " +list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("yasar hameed")) {
				list.get(i).click();
				break;
			}
		}
		driver.close();

	}

}
