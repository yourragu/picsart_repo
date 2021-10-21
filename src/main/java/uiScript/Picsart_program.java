package uiScript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Picsart_program extends BaseClass {

	@Test
	public void taskA() throws IOException, InterruptedException {
		launchBrowser();
		System.out.println("Executing 1st Method");
		act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//strong[text()='Learn']")))
				.moveToElement(driver.findElement(By.xpath("//strong[text()='Blog']"))).click().build().perform();
		consolePrint("Blog");
		takeSnap("Blog");
		driver.navigate().back();
		act.moveToElement(driver.findElement(By.xpath("//strong[text()='Learn']")))
				.moveToElement(driver.findElement(By.xpath("//strong[text()='Design School']"))).click().build()
				.perform();
		consolePrint("Design School");
		takeSnap("Design School");
		driver.findElement(By.xpath("//a[text()='Trends']")).click();
		consolePrint("Trends");
		takeSnap("Trends");
		navigateTo_BackScreen();
		driver.findElement(By.xpath("//a[text()='Picsart Pro']")).click();
		consolePrint("Picsart Pro");
		takeSnap("Picsart_Pro");
		navigateTo_BackScreen();
		driver.findElement(By.xpath("//a[text()='News']")).click();
		consolePrint("News");
		takeSnap("News");

		act.moveToElement(driver.findElement(By.xpath("//button[@aria-label='search']/i")))
				.moveToElement(driver.findElement(By.xpath("//input[@name='search']"))).click().build().perform();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("my photos");
		Thread.sleep(2000);// Used this method for better UI visualization for the user
		driver.findElement(By.xpath("//button[@aria-label='search']/i")).click();
		Thread.sleep(5000); // Added thread.sleep method for UI visualization

	}

	@Test
	public void taskB() throws IOException, InterruptedException {
		launchBrowser();
		System.out.println("Executing 2nd Method");
		act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//strong[text()='Learn']")))
				.moveToElement(driver.findElement(By.xpath("//strong[text()='Blog']"))).click().build().perform();
		consolePrint("Blog");
		takeSnap("Blog");
		for (int i = 1; i < 4; i++) {
			Thread.sleep(2000); // Used this method for better UI visualization for the user
				driver.findElement(By.xpath("(//button[contains(@class,'arrow-button')])[2]/i")).click();
		}
	}
	
	

	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://picsart.com/create");
		driver.manage().window().maximize();
	}

}
