package asrerena;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class HandlingInternetConnection extends BaseTest {
	@SuppressWarnings("deprecation")
	@Test
	public void InternetConnection () throws MalformedURLException, URISyntaxException, InterruptedException
	{
		//Verify offline message is displayed when having internet issue
		AirplaneMode();
		Thread.sleep(10000);
		WebElement offlineMessage = driver.findElement(AppiumBy.accessibilityId("You're currently offline!"));
		Assert.assertTrue(offlineMessage.isDisplayed());
		
		for(int i = 0; i < 4; i++ ) {
			driver.findElement(AppiumBy.accessibilityId("Retry")).click();
			Thread.sleep(4000);
		}
		//TC_4 Validate that retry button is been click when offline message is been displayed
		if (offlineMessage.isDisplayed()) {
			RestoreNetwork();
			driver.findElement(AppiumBy.accessibilityId("Retry")).click();
			
		}
		
		
		//Verify that connection status has been restored and also verifying that the user is on same page before network error
		
		Thread.sleep(10000);
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
		driver.findElement(AppiumBy.accessibilityId("Proceed")).click();
		Thread.sleep(7000);
			
	}
}
