package com.pom.bms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchMovies {
	public SearchMovies(WebDriver driver) {
		  PageFactory.initElements(driver, this);
	}
	public static WebElement movieSearch(WebDriver driver) {
        return  driver.findElement(By.xpath("//span[text()='Search for Movies, Events, Plays, Sports and Activities']"));
    }
    public static WebElement movienameEnter(WebDriver driver) {
        return  driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/div/input"));
    }
}
