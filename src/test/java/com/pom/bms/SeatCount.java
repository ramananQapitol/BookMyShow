package com.pom.bms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SeatCount {
	 public SeatCount(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		
	}
	 public static WebElement procceedQty(WebDriver driver) {
         return driver.findElement(By.xpath("//*[@id=\"proceed-Qty\"]"));
	    }
     public static WebElement btmcmntBook(WebDriver driver) {
        return driver.findElement(By.id("btmcntbook"));
	    }
     public static WebElement shmTicket(WebDriver driver) {
        return driver.findElement(By.id("shmticket"));
	    }
}
