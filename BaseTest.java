package asrerena;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BaseTest {
	public AndroidDriver driver ;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException
	{
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\MR.OPEYEMI\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Opeyeiemulator");
		//options.setApp("C:\\Users\\MR.OPEYEMI\\eclipse-workspace\\Quabana\\src\\test\\java\\resources\\APKFiles\\resources\\app-release.apk");
		options.setApp("C:\\Users\\MR.OPEYEMI\\eclipse-workspace\\Quabana\\src\\test\\java\\resources\\APKFiles\\resources\\app-releasefour.apk");

		//options.setApp("C:\\Users\\MR.OPEYEMI\\eclipse-workspace\\Quabana\\src\\test\\java\\resources\\APKFiles\\resources\\ApiDemos-debug.apk");


		driver = new AndroidDriver (new URI("http://127.0.0.1:4723").toURL(), options); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void LongPressAction (WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration", 2000));
	}
	
	

	public void swipeElement(WebElement element, String direction) {
	    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
	        "elementId", ((RemoteWebElement) element).getId(),
	        "direction", direction,
	        "percent", 0.3	  
	    ));
    
	}
	

	
	public void swipeElementI(WebElement element, String direction) {
	    // Get the location and size of the element
	    org.openqa.selenium.Point location = element.getLocation();
	    org.openqa.selenium.Dimension size = element.getSize();

	    // Calculate the center of the element
	    int centerX = location.getX() + size.getWidth() / 2;
	    int centerY = location.getY() + size.getHeight() / 2;

	    // Define the swipe direction
	    int startX, startY, endX, endY;
	    switch (direction.toLowerCase()) {
	        case "left":
	            startX = (int) (centerX + size.getWidth() * 0.25);
	            endX = (int) (centerX - size.getWidth() * 0.25);
	            startY = centerY;
	            endY = centerY;
	            break;
	        case "right":
	            startX = (int) (centerX - size.getWidth() * 0.25);
	            endX = (int) (centerX + size.getWidth() * 0.25);
	            startY = centerY;
	            endY = centerY;
	            break;
	        case "up":
	            startX = centerX;
	            endX = centerX;
	            startY = (int) (centerY + size.getHeight() * 0.25);
	            endY = (int) (centerY - size.getHeight() * 0.25);
	            break;
	        case "down":
	            startX = centerX;
	            endX = centerX;
	            startY = (int) (centerY - size.getHeight() * 0.25);
	            endY = (int) (centerY + size.getHeight() * 0.25);
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid direction: " + direction);
	    }

	    // Create a PointerInput object for touch actions
	    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

	    // Create a sequence of actions
	    Sequence swipe = new Sequence(finger, 0)
	        .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
	        .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY))
	        .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    // Perform the swipe action
	    ((AppiumDriver) driver).perform(Collections.singletonList(swipe));
	}

	public void infiniteSwipeThroughImages() throws InterruptedException {
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

	        System.out.println("Restarting swipe from first image...");
	    }
	}
	public void swipeToLastAndBack() {
	    List<WebElement> images = driver.findElements(By.xpath("//android.widget.ImageView")); // Get all images

	    if (images.isEmpty()) {
	        System.out.println("No images found!");
	        return; // Stop if no images are detected
	    }

	    int totalImages = images.size();
	    System.out.println("Total Images Found: " + totalImages);

	    // Swipe LEFT to last image
	    for (int i = 0; i < totalImages - 1; i++) { 
	        images = driver.findElements(By.xpath("//android.widget.ImageView")); // Refresh elements
	        WebElement image = images.get(i);
	        System.out.println("Swiping LEFT: Image #" + (i + 1));

	        swipeElement(image, "up"); // Perform swipe left

	        try {
	            Thread.sleep(1000); // Small delay for UI update
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    System.out.println("Reached last image. Swiping back...");

	    // Swipe RIGHT back to first image
	    for (int i = totalImages - 1; i > 0; i--) { 
	        images = driver.findElements(By.xpath("//android.widget.ImageView")); // Refresh elements
	        WebElement image = images.get(i);
	        System.out.println("Swiping RIGHT: Image #" + (i + 1));

	        swipeElement(image, "down"); // Perform swipe right

	        try {
	            Thread.sleep(1000); // Small delay for UI update
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    System.out.println("Returned to the first image. Stopping...");
	}


	
	

	  public void AirplaneMode() {
		  driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
	  }
	  public void RestoreNetwork() {
			driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
	  }
	@AfterClass
	public void TearDown() 
	{
		driver.quit();
		service.stop();
	}
	 
	
}
