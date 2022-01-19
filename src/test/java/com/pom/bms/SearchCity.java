package com.pom.bms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchCity {
	public SearchCity(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		
	}
	public static WebElement location(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='sc-kaNhvL jlISnX ellipsis']"));
    }

    public static WebElement searchForCity(WebDriver driver) {

        return driver.findElement(By.xpath("//input[@placeholder='Search for your city']"));
    }

}
