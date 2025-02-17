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

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class VerifyDisplayOfShortMessages extends BaseTest {
	@SuppressWarnings("deprecation")
	@Test
	public void DisplayOfShortMessages () throws MalformedURLException, URISyntaxException, InterruptedException
	{
		RestoreNetwork();
		Thread.sleep(4000);
		WebElement Message = driver.findElement(AppiumBy.accessibilityId("Immerse yourself in Scripture through a visually rich and engaging journey, bringing timeless wisdom to life in a whole new way."));
		Assert.assertTrue(Message.isDisplayed());
		
	}

	private KeyEvent KeyEvent(AndroidKey enter) {
		// TODO Auto-generated method stub
		return null;
	}
}
