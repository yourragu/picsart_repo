package commonMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public RemoteWebDriver driver;
	public Actions act;

	@BeforeMethod
	public void startApp() {
		WebDriverManager.chromedriver().setup();
	}
	

	@AfterMethod
	public void closeApp() {
		driver.close();
	}


	public void navigateTo_BackScreen() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(3000);
	}

	public void consolePrint(String value) throws InterruptedException {
		System.out.println("Successfully clicked the link => " + value);
		
	}

	public void takeSnap(String value) throws IOException, InterruptedException {

		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenShot/" + value+".png");
		FileUtils.copyFile(src, dest);
		Thread.sleep(5000);
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(4);
	}
	

}
