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

public class VerseOfTheDay extends BaseTest {
	@SuppressWarnings("deprecation")
	@Test
	public void 	VerseOfTheDay () throws MalformedURLException, URISyntaxException, InterruptedException
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
		
	  try {
	        Thread.sleep(10000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
*/
	    
		
	    driver.findElement(By.xpath("//android.widget.ImageView[@index = '4']")).click();
	    WebElement FirstVerse = driver.findElement(By.xpath("//android.view.View[@index = '1']"));
	    wait.until(ExpectedConditions.visibilityOf(FirstVerse));
	    Assert.assertTrue(FirstVerse.isDisplayed());
	    Thread.sleep(3000);
	    int maxSwipes = 6; // Limit swiping to 5 cycles
	    int swipeCount = 0;
 
	    while (swipeCount < maxSwipes) { // Run only 3 times
	        List<WebElement> images = driver.findElements(By.xpath("//android.widget.ImageView")); // Get all images again

	        if (images.isEmpty()) {
	            System.out.println("No images found!");
	            break;  // Stop if no images are detected
	        }

	        System.out.println("Total Images Found: " + images.size());

	        for (int i = 0; i < images.size(); i++) {
	            // Re-fetch the image to prevent StaleElementReferenceException
	            images = driver.findElements(By.xpath("//android.widget.ImageView"));

	            if (i >= images.size()) break; // Prevent IndexOutOfBoundsException

	            WebElement image = images.get(i);
	            System.out.println("Swiping Image #" + (swipeCount + 1));

	            swipeElement(image, "right"); // Perform swipe

	            swipeCount++; // Increment counter

	            try {
	                Thread.sleep(1000); // Small delay for UI update
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            if (swipeCount >= maxSwipes) break; // Stop after 3 swipes
	        }

	        System.out.println("Completed " + swipeCount + " swipes. Stopping...");
	    }
	    try {
            Thread.sleep(5000); // Small delay for UI update
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	    
	    int maxSwipes2 = 5; // Limit swiping to 5 cycles
	    int swipeCount2 = 0;

	    while (swipeCount2 < maxSwipes2) { // Run only 3 times
	        List<WebElement> images = driver.findElements(By.xpath("//android.widget.ImageView")); // Get all images again

	        if (images.isEmpty()) {
	            System.out.println("No images found!");
	            break;  // Stop if no images are detected
	        }

	        System.out.println("Total Images Found: " + images.size());

	        for (int i = 0; i < images.size(); i++) {
	            // Re-fetch the image to prevent StaleElementReferenceException
	            images = driver.findElements(By.xpath("//android.widget.ImageView"));

	            if (i >= images.size()) break; // Prevent IndexOutOfBoundsException

	            WebElement image = images.get(i);
	            System.out.println("Swiping Image #" + (swipeCount + 1));

	            swipeElement(image, "left"); // Perform swipe

	            swipeCount2++; // Increment counter

	            try {
	                Thread.sleep(1000); // Small delay for UI update
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            if (swipeCount2 >= maxSwipes) break; // Stop after 3 swipes
	        }

	        System.out.println("Completed " + swipeCount2 + " swipes. Stopping...");
	    }
	    
	    List<WebElement> images = driver.findElements(By.xpath("//android.widget.ImageView"));

	    if (!images.isEmpty()) {
	        WebElement lastImage = images.get(images.size() - 1);
	        lastImage.click();
	        System.out.println("Clicked on the last image.");
	    } else {
	        System.out.println("No images found to click.");
	    }
	    
	    WebElement scrollableElement2  = driver.findElement(By.xpath("//android.view.View[@index = '6']")); 
	    boolean canScrollMore2;
		do {
			canScrollMore2 = (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"elementId", ((org.openqa.selenium.remote.RemoteWebElement) scrollableElement2).getId(),
				"left", 100,
				"top", 100,
				"width", 200,
				"height", 200,
				"direction", "down",
				"percent", 10.0
				));
		}while(canScrollMore2);

	    try {
	        Thread.sleep(1000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
	  //  scrollableElement2  = driver.findElement(By.xpath("//android.view.View[@index = '6']")); 
	    boolean canScrollMore3;
		do {
			canScrollMore3 = (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"elementId", ((org.openqa.selenium.remote.RemoteWebElement) scrollableElement2).getId(),
				"left", 100,
				"top", 100,
				"width", 200,
				"height", 200,
				"direction", "up",
				"percent", 10.0
				));
		}while(canScrollMore3);
		
		 
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
	  
	  try {
	        Thread.sleep(10000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	}
	    
	}
	        

	        

	        
	    
	
		
	
		
	  
		
	
    



