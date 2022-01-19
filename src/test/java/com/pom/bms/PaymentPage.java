package com.pom.bms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	public PaymentPage (WebDriver driver) {
		  PageFactory.initElements(driver, this);
		
	}
	public static WebElement prepay(WebDriver driver) {
      return driver.findElement(By.id("prePay"));
    }
   
}
