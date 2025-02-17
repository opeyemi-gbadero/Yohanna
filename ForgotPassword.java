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

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ForgotPassword extends BaseTest {
	@SuppressWarnings("deprecation")
	@Test
	public void SignUp_TC_6 () throws MalformedURLException, URISyntaxException, InterruptedException
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
		driver.findElement(AppiumBy.accessibilityId("Forgot Password?")).click();
		driver.findElement(By.xpath("//android.widget.EditText")).click();
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("opeyemigbadero24@gmail.com");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.xpath("//android.widget.Button[@content-desc = 'Reset Password']")).click();
		Thread.sleep(4000);
		WebElement Token = driver.findElement(By.xpath("//android.widget.EditText[@index = '7']"));
		Token.click();
		Token.sendKeys("****");
		WebElement CreateNewPassword = driver.findElement(By.xpath("//android.widget.EditText[@index = '8']"));
		CreateNewPassword.click();
		CreateNewPassword.sendKeys("1213123122");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		WebElement ConfirmPassword = driver.findElement(By.xpath("//android.widget.EditText[@index = '9']"));
		ConfirmPassword.click();
		ConfirmPassword.sendKeys("1213123122");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		  try {
		        Thread.sleep(5000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
	  driver.findElement(AppiumBy.accessibilityId("Reset Password")).click();

    

}
}
