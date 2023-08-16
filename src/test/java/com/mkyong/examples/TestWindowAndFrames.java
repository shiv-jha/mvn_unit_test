package com.mkyong.examples;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestWindowAndFrames {

	
	
	@Test
    public void testNestedFrames() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	WebDriver driver = new ChromeDriver(options);
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	driver.get("https://demoqa.com/nestedframes");
    	driver.switchTo().frame(driver.findElement(By.id("frame1")));
    	System.out.println(driver.getPageSource());
    	driver.switchTo().frame(0);
    	System.out.println(driver.getPageSource());
	}
	//@Test
    public void testWindowhandle() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	WebDriver driver = new ChromeDriver(options);
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	driver.get("https://demoqa.com/browser-windows");
    	String currentBrowserHandle=driver.getWindowHandle();
    	driver.findElement(By.id("windowButton")).click();
    	Set<String> handles = driver.getWindowHandles();
    	String newBrowser="";
    	for(String handle:handles) {
    		if(!handle.equals(currentBrowserHandle)) {
    			newBrowser=handle;
    		}
    	}
    	driver.switchTo().window(newBrowser);
    	System.out.println(driver.findElement(By.id("sampleHeading")).getText());
    	driver.switchTo().defaultContent();
    	driver.findElement(By.id("windowButton")).click();
    	
	}
    

}
