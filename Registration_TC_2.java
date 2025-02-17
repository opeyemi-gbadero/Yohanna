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

public class Registration_TC_2 extends BaseTest {
	@SuppressWarnings("deprecation")
	@Test
	public void SignUp_TC_6 () throws MalformedURLException, URISyntaxException, InterruptedException
	{
		WebElement splash = driver.findElement(AppiumBy.accessibilityId("Praises"));
		Assert.assertTrue(splash.isDisplayed());
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
		driver.findElement(AppiumBy.accessibilityId("Proceed")).click();
		
		// TC_2 Registration
		//user inputting data on registration page
		
		driver.findElement(By.xpath("//android.widget.EditText[@index = '1']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index = '1']")).sendKeys("Opeyemi Gbadero");
		driver.findElement(By.xpath("//android.widget.EditText[@index = '2']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index = '2']")).sendKeys("opeyemigbadero14@gmail.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement setupPassword = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//android.widget.EditText[@hint='Setup your password']")));
		setupPassword.click();
	    setupPassword.sendKeys("Opeyemigbadero24*#");
	    driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	    WebElement confirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@hint='Confirm password']")));
        confirmPassword.click();
        confirmPassword.sendKeys("Opeyemigbadero24*#");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        try {
	        Thread.sleep(10000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		driver.findElement(AppiumBy.accessibilityId("Choose your language\nEnglish")).click();
		driver.findElement(AppiumBy.accessibilityId("Proceed")).click();
		 try {
		        Thread.sleep(5000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		driver.findElement(AppiumBy.accessibilityId("Choose your language\nEnglish")).click();
		driver.findElement(AppiumBy.accessibilityId("Portuguese")).click();
		driver.findElement(AppiumBy.accessibilityId("Proceed")).click();
		//driver.findElement(By.xpath("//android.view.View[@content-desc=\"Portuguese\"]/android.widget.RadioButton")).click();
		driver.findElement(AppiumBy.accessibilityId("Get me started")).click();
		
		  try {
		        Thread.sleep(20000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
}
}
