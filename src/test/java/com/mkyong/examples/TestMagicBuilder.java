package com.mkyong.examples;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestMagicBuilder {

    @Test
    public void testLucky() {
    	System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://tutorialsninja.com/demo");
		
		//count number of product didplayed in the page
		List<WebElement> allProduct=driver.findElements(By.xpath("//div[starts-with(@class,'product-layout')]"));
		//assertEquals(4, allProduct.size());
		driver.findElement(By.xpath("//a[text()='iPhone']")).click();
		String myprice=driver.findElement(By.xpath("//div[@id='content']//h2[contains(text(),'$')]")).getText();
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys("2");
		driver.findElement(By.id("button-cart")).click();
		System.out.println("test completed");
		driver.quit();
    }

}
