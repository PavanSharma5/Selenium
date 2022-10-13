package seleniumchenai.testing;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class First {

	// Maximize method
	void maximize(WebDriver driver) {
		driver.manage().window().maximize();

	}

	// fullscreen
	void fullscreen(WebDriver driver) {
		driver.manage().window().fullscreen();
	}

	// opening any url
	void openurl(WebDriver driver) {
		driver.get("http://www.greenstechnologys.com/");
	}

	

	void ss(WebDriver driver) throws IOException {
		// step1 --- 
		
		TakesScreenshot ref = (TakesScreenshot) driver;
		// step2
		File source = ref.getScreenshotAs(OutputType.FILE);
		// step3
		File destination = new File(
				"C:\\Users\\Pavan sharma\\eclipse-workspace\\Hello\\seleniumchenai\\screenshot\\one.png");
		// step4
		FileUtils.copyFile(source, destination);

	}
	void actions(WebDriver driver) {
		WebElement findElement = driver.findElement(By.xpath("//a[text()='COURSES']"));
		Actions a1 = new Actions(driver);
		a1.moveToElement(findElement).build().perform();
		WebElement findElement2 = driver.findElement(By.xpath("//span[text()='Selenium'][1]"));
		a1.click(findElement2).build().perform();
	}
	void ss2(WebDriver driver) throws IOException {
		File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, new File("C:\\Users\\Pavan sharma\\eclipse-workspace\\Hello\\seleniumchenai\\screenshot\\two.png"));
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pavan sharma\\DriversForSelenium\\chromedriver.exe");
		First obj = new First();
		WebDriver driver = new ChromeDriver();
		obj.maximize(driver);
		// obj.fullscreen(driver);
		obj.openurl(driver);
		Thread.sleep(5000);
		obj.ss(driver);
		obj.actions(driver);
		obj.ss2(driver);

	}

}
