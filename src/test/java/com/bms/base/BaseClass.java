package com.bms.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
	static String noOfTickets = "2";
public void robotPressandRelease() throws AWTException {
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);

}
public void Wait(WebElement element,int time) {
	WebDriverWait wait = new WebDriverWait(driver, 100);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void WaitToClick(int time) throws InterruptedException {
	Thread.sleep(time);

}
}

