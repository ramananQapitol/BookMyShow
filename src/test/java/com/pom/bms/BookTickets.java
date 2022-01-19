package com.pom.bms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class BookTickets {
	static String noOfTickets = "2";
  public BookTickets(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		
	}
	 public static WebElement bookTicketsbtn(WebDriver driver) {
	        return  driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/section[1]/div/div/div[2]/div[2]/div/button"));
	    }
    public static WebElement dateClick(WebDriver driver) {
            return driver.findElement(By.xpath("//a[contains(@href,'tomorrow')][1]"));
	    }

    public static WebElement showTime(WebDriver driver) {
    	    return driver.findElement(By.xpath("//a[@data-date-time='06:30 PM']"));
	    }
    public static WebElement acceptpopupButton(WebDriver driver) {
          return driver.findElement(By.id("btnPopupAccept"));
    }
    public static WebElement tickets(WebDriver driver) {
        return driver.findElement(By.xpath(".//*[@id='popQty']/*[text()='"+noOfTickets+"']"));
    }

}
