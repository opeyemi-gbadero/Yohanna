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

public class Swipe0ne extends BaseTest {
	@SuppressWarnings("deprecation")
	@Test
	public void SignIn_TC_6 () throws MalformedURLException, URISyntaxException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


	  
	        // Infinite swipe loop
	    int swipeCount = 0;
	    
	    while (true) { // Infinite loop
	        List<WebElement> images = driver.findElements(By.xpath("//android.widget.ImageView")); // Get all images again
	        
	        if (images.size() == 0) {
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

	            swipeElement(image, "left"); // Call your swipe function

	            swipeCount++;  // Increment counter

	        }

	        
	    }
	}
	
		

		/*WebElement splash = driver.findElement(AppiumBy.accessibilityId("Praises"));
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
	    WebElement Ready = driver.findElement(AppiumBy.accessibilityId("I’m ready to start my journey"));
	    Assert.assertTrue(Ready.isDisplayed());
	    Ready.click();*/
	    
		
	
    

}

