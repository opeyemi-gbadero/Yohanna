package asrerena;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class PrayerForMySelf extends BaseTest {
	@SuppressWarnings("deprecation")
	@Test
	public void 	Request_Prayer () throws MalformedURLException, URISyntaxException, InterruptedException
	{
		WebElement splash = driver.findElement(AppiumBy.accessibilityId("Praises"));
		Assert.assertTrue(splash.isDisplayed());
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
		driver.findElement(AppiumBy.accessibilityId("Proceed")).click();
        WebElement scrollableElement = driver.findElement(AppiumBy.className("android.view.View"));

		boolean canScrollMore;
		do {
			canScrollMore = (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"elementId", ((org.openqa.selenium.remote.RemoteWebElement) scrollableElement).getId(),
				"left", 100,
				"top", 100,
				"width", 200,
				"height", 200,
				"direction", "down",
				"percent", 10.0
				));
		}while(canScrollMore);
		driver.findElement(AppiumBy.accessibilityId("Already have an account? \nSign in here")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index = '2']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index = '2']")).sendKeys("opeyemigbadero24@gmail.com");
		driver.findElement(By.xpath("//android.widget.EditText[@index = '3']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index = '3']")).sendKeys("Opeyemi24*#");
	    driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	    driver.findElement(AppiumBy.accessibilityId("Sign in")).click();
	    try {
	        Thread.sleep(5000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    /* WebElement FirstPage = driver.findElement(By.xpath("//android.view.View[@index = '0']"));
	    Assert.assertTrue(FirstPage.isDisplayed());
	    swipeElement(FirstPage, "left");
	    
	   
		  try {
	        Thread.sleep(5000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		FirstPage.click();
		
	

  	  try {
	        Thread.sleep(3000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
  	  
		FirstPage.click();
		
	  try {
	        Thread.sleep(10000);
	    } catch (InterruptedException e) { 
	        e.printStackTrace();
	    }
	  
	  
	  for(int i = 0; i < 3; i++) {
		  WebElement Next = driver.findElement(AppiumBy.accessibilityId("Next"));
		  Next.click(); 
	  }
	  WebElement Done = driver.findElement(AppiumBy.accessibilityId("Done"));
	  Done.click(); 
		*/
	 /* try {
	        Thread.sleep(10000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }*/

	
	    //WebElement Ready = wait.until(ExpectedConditions.visibilityOfElementLocated( AppiumBy.accessibilityId("I’m ready to start my journey")));
	    //Ready.click();
		driver.findElement(By.xpath("//android.widget.ImageView[@index = '5']")).click();
	    WebElement RequestPrayer = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Request a prayer\"]"));
	    Assert.assertTrue(RequestPrayer.isDisplayed());
	    RequestPrayer.click();
	   
	    
	    driver.findElement(AppiumBy.accessibilityId("Request Prayer")).click();
	    
	    WebElement Prayer = driver.findElement(By.xpath("//android.widget.EditText[@index = '1']"));
	    Prayer.click();
	    Prayer.sendKeys("i needs prayer for healing");
	    driver.findElement(AppiumBy.accessibilityId("Request Prayer")).click();
	    WebElement Point1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index = '0']")));
	    wait.until(ExpectedConditions.elementToBeClickable(Point1));
	    Assert.assertTrue(Point1.isDisplayed(), "Point1 is NOT displayed on screen!");
	    System.out.println("Point1 is now visible on screen");
	    
	    
	    System.out.println("Swiping Point1 to the left...");
	    //swipeElement(Point1, "left");

	    WebElement NextElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@index = '1']")));
	    wait.until(ExpectedConditions.elementToBeClickable(NextElement));
    	Assert.assertTrue(NextElement.isDisplayed(), "Next element did not load after swipe!");
	    System.out.println("Swiping Point1 to the left...");
    	swipeElement(Point1, "left");
    	swipeElement(Point1, "right");

	    System.out.println("Swipe action successful!");
		
	    try {
	        Thread.sleep(10000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    driver.findElement(AppiumBy.accessibilityId("Share Now")).click(); 
	    
	    try {
	        Thread.sleep(10000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    /*WebElement PrayerPoint = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.ImageView")));
	    wait.until(ExpectedConditions.visibilityOf(PrayerPoint));
	    Assert.assertTrue(PrayerPoint.isDisplayed());
	    Assert.assertTrue(PrayerPoint.isEnabled(), "PrayerPoint is not clickable.");
	    wait.until(ExpectedConditions.elementToBeClickable(PrayerPoint));*/
	   
	   
	   
	   
	
    

}
}
