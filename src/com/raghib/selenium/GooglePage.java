package com.raghib.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
	
	public static String url = "http://www.google.com";
	public static String googleSearchBox = "//input[@name='q']";
	public static String linkPath = "//body/div[@id='main']/div[@id='cnt']/div[@id='rcnt']/div[@id='center_col']/div[@id='res']/div[@id='search']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/h3[1]";
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
                "C:\\SELENIUM\\browser-driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath(googleSearchBox));
		
		Duration duration = Duration.ofSeconds(30);
		
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(googleSearchBox)));
		
		element.sendKeys("selenium");
		element.sendKeys(Keys.ENTER);

		WebDriverWait wait1 = new WebDriverWait(driver, duration);
		wait1.until(ExpectedConditions.elementToBeClickable((By.xpath(linkPath)))).click();

		Thread.sleep(5000);
		driver.quit();
	}
}
