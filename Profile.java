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

public class Profile extends BaseTest {
	@SuppressWarnings("deprecation")
	@Test
	public void 	BibleBooks () throws MalformedURLException, URISyntaxException, InterruptedException
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

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	   /*x WebElement FirstPage = driver.findElement(By.xpath("//android.view.View[@index = '0']"));
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
	  WebElement Grace  = driver.findElement(AppiumBy.accessibilityId("Tap the Grace icon to request a prayer or check in on your mood. It’s your personal gateway to spiritual support and emotional connection\\n1 of 4"));
	  wait.until(ExpectedConditions.visibilityOf(Grace));
	  Assert.assertTrue(Grace.isDisplayed());
	  System.out.println("Grace is displayed");

	  for(int i = 0; i < 3; i++) {
		  WebElement Next = driver.findElement(AppiumBy.accessibilityId("Next"));
		  Next.click(); 
	  }
	  WebElement Done = driver.findElement(AppiumBy.accessibilityId("Done"));
	  Done.click(); */
		
	

	  

	    driver.findElement(By.xpath("//android.widget.ImageView[@index = '1']")).click();
        WebElement ProfileSection = driver.findElement(By.className("android.view.View"));
        wait.until(ExpectedConditions.visibilityOf(ProfileSection));
        Assert.assertTrue(ProfileSection.isDisplayed());
        System.out.println("Profile section is displayed");
        
    
        
		WebElement versionElement = driver.findElement(By.xpath("//android.widget.ImageView[contains(@content-desc, 'Bible Version') and contains(@content-desc, 'KJV')]"));


        // Use the helper method from the BaseTest
		versionElement.click();
        
        WebElement ASV = driver.findElement(AppiumBy.accessibilityId("American Standard Version"));
        ASV.click();
  
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        try {
	        Thread.sleep(7000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
        driver.findElement(By.xpath("//android.widget.ImageView[@index = '1']")).click();
       
        
        WebElement AsvElement =driver.findElement(AppiumBy.accessibilityId("Bible Version\nASV"));
        AsvElement.click();
        
        
        WebElement BBE = driver.findElement(AppiumBy.accessibilityId("Bible in Basic English"));
        BBE.click();
      
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        try {
	        Thread.sleep(7000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
        driver.findElement(By.xpath("//android.widget.ImageView[@index = '1']")).click();
        try {
	        Thread.sleep(7000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
        driver.findElement(AppiumBy.accessibilityId("Bible Version\nBBE")).click();
	 
        
        WebElement WEB = driver.findElement(AppiumBy.accessibilityId("World English Bible"));
        WEB.click();
        try {
	        Thread.sleep(10000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        try {
	        Thread.sleep(10000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
        driver.findElement(By.xpath("//android.widget.ImageView[@index = '1']")).click();
        try {
	        Thread.sleep(10000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
        driver.findElement(AppiumBy.accessibilityId("Bible Version\nWEB")).click();
        try {
	        Thread.sleep(10000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
        WebElement YLT = driver.findElement(AppiumBy.accessibilityId("Young's Literal Translation"));
        YLT.click();
	    
	   
		  try {
		        Thread.sleep(10000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		  driver.pressKey(new KeyEvent(AndroidKey.BACK));
		  try {
		        Thread.sleep(10000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
	    //driver.findElement(AppiumBy.accessibilityId("Genesis 1:1")).click();
	  //  WebElement Books = driver.findElement(By.xpath("//android.view.View[@index = '0']"));
	   // Assert.assertTrue(Books.isDisplayed());
	    
	  
    

	  
	    

}
}
