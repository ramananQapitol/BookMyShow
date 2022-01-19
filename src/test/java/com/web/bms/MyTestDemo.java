package com.web.bms;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bms.base.BaseClass;
import com.pom.bms.BookTickets;
import com.pom.bms.PaymentPage;

import com.pom.bms.SearchCity;
import com.pom.bms.SearchMovies;
import com.pom.bms.SeatCount;

import io.github.bonigarcia.wdm.WebDriverManager;
public class MyTestDemo extends BaseClass{
         WebDriver driver;
		 static String noOfTickets = "2";
		    BaseClass base= new BaseClass();
		    SearchCity search=new SearchCity(driver);
			SearchMovies movies=new SearchMovies(driver);
			BookTickets book =new BookTickets(driver);
			SeatCount count = new SeatCount(driver);
			PaymentPage pay = new PaymentPage(driver);
	@BeforeClass
	public void browser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		
		}
	@Test(dataProvider="Login",groups="Booking")
	public void bookingTickets(String movie,String location) throws InterruptedException, AWTException  {
		driver.get("https://in.bookmyshow.com/explore/home/chennai");
		driver.manage().window().maximize();
		search.location(driver).click();
		base.WaitToClick(2000);
		search.searchForCity(driver).sendKeys(location);
		base.robotPressandRelease();
        movies.movieSearch(driver).click();
	    movies.movienameEnter(driver).sendKeys(movie);
	    base.WaitToClick(2000);
	    base.robotPressandRelease();
	    book.bookTicketsbtn(driver).click();
		book.dateClick(driver).click();
		book.showTime(driver).click();
		book.acceptpopupButton(driver).click();
		base.WaitToClick(5000);
		book.tickets(driver).click();
		SeatCount.procceedQty(driver).click();
		base.WaitToClick(5000);
		
	    List<WebElement> aseats;
	    List<WebElement> sseats;
	    int i=0;
	    int selected = 0;
	    List<WebElement> rows = driver.findElements(By.xpath("//td/div[@class='seatR Setrow1']"));
	    while(selected<Integer.parseInt(noOfTickets)){
	    WebElement row = rows.get(i);
	    aseats = row.findElements(By.xpath("../following-sibling::td//a[@class='_available']"));
	    while(selected<Integer.parseInt(noOfTickets)){
	    if(aseats.size()>0){
	    aseats.get(0).click();
	    sseats = row.findElements(By.xpath("../following-sibling::td//a[@class='_available _selected']"));
	    aseats = row.findElements(By.xpath("../following-sibling::td//a[@class='_available']"));
	    selected+=sseats.size();
	  }
	  }
	    i++;
	    if(i==rows.size())
	    break;
	  }
	    base.WaitToClick(10000);
        count.btmcmntBook(driver).click();
        base.WaitToClick(10000);
        count.shmTicket(driver).click();
	    pay.prepay(driver).click();
	    base.WaitToClick(10000);
	   
       }
		
    @DataProvider(name="Login")
	public Object [][] data() {
		return new Object[][] {
			{"Enna solla pogirai","chennai"},
			{"kombu vatcha singamda","Coimbatore"}
	};
	}
		
		
		@AfterClass
		public void tearDown() {
			driver.close();

    }
    }
