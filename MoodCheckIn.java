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
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MoodCheckIn extends BaseTest {
	@SuppressWarnings("deprecation")
	@Test
	public void 	MoodCheckIn () throws MalformedURLException, URISyntaxException, InterruptedException
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
	        Thread.sleep(20000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement FirstPage = driver.findElement(By.xpath("//android.view.View[@index = '0']"));
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
		
	  try {
	        Thread.sleep(10000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }


	    
		driver.findElement(By.xpath("//android.widget.ImageView[@index = '5']")).click();
	    WebElement MoodCheck = driver.findElement(AppiumBy.accessibilityId("Mood Check-In"));
	    Assert.assertTrue(MoodCheck.isDisplayed());
	    MoodCheck.click();
	    WebElement Overwhelmed = driver.findElement(AppiumBy.accessibilityId("Overwhelmed"));
	    swipeElement(Overwhelmed, "left");
	    driver.findElement(AppiumBy.accessibilityId("Lonely")).click();
	    WebElement Frustrated = driver.findElement(AppiumBy.accessibilityId("Frustrated"));
	    Frustrated.click();
	    driver.findElement(AppiumBy.accessibilityId("Sad")).click();
 		Thread.sleep(4000);
	    swipeElement(Frustrated, "right");

	    Overwhelmed.click();
	    
	    driver.findElement(AppiumBy.accessibilityId("Hopeful")).click();
	    
	    driver.findElement(AppiumBy.accessibilityId("Joyful")).click();
	    


	    driver.findElement(AppiumBy.accessibilityId("Proceed")).click();
	    WebElement MoodTextBox = driver.findElement(By.className("android.widget.EditText"));
	    MoodTextBox.click();
	    MoodTextBox.sendKeys("So lonely");
	    driver.findElement(AppiumBy.accessibilityId("Let's pray")).click();
	    WebElement PrayerPoint = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.ImageView")));
	    wait.until(ExpectedConditions.visibilityOf(PrayerPoint));
	    Assert.assertTrue(PrayerPoint.isDisplayed());
	    Assert.assertTrue(PrayerPoint.isEnabled(), "PrayerPoint is not clickable.");
	    wait.until(ExpectedConditions.elementToBeClickable(PrayerPoint));
	    Thread.sleep(7000);
	    PrayerPoint.click();
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
    

}
}
