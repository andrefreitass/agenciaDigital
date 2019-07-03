package test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log4j {

	private static WebDriver driver;

	private static Logger Log = Logger.getLogger(Log4j.class.getName());

	public static void main(String[] args) {

		DOMConfigurator.configure("/home/andre/Developer/work/PortalIdeiaDataPoolExcel/src/test/java/br/com/portalIdeia/log4j.xml");

		// Create a new instance of the Firefox driver

    	System.setProperty("webdriver.chrome.driver",
				"/home/andre/Developer/work/teste/src/test/java/teste/drivers/chromedriver");
         
    	WebDriver driver = new ChromeDriver();
    	
    	Log.info("TESTE ANDREEEEEEEEEEEEEEEEEe");

		Log.info("New driver instantiated");

		// Put a Implicit wait, this means that any search for elements on the page
		// could take the time the implicit wait is set for before throwing exception

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Log.info("Aguardar navegador ser carregado");

		// Launch the Online Store Website

		driver.get("http://www.google.com.br");

		Log.info("Navegador inicialiado");

		// Find the element that's ID attribute is 'account'(My Account)

		driver.findElement(By.name("q")).sendKeys("teste automacao");

		Log.info("Click action performed on My Account link");

		// Find the element that's ID attribute is 'log' (Username)

		// Enter Username on the element found by above desc.

		//driver.findElement(By.id("log")).sendKeys("testuser_1");

		Log.info("Username entered in the Username text box");

		// Find the element that's ID attribute is 'pwd' (Password)

		// Enter Password on the element found by the above desc.

		//driver.findElement(By.id("pwd")).sendKeys("Test@123");

		Log.info("Password entered in the Password text box");

		// Now submit the form. WebDriver will find the form for us from the element

		//driver.findElement(By.id("login")).click();

		Log.info("Click action performed on Submit button");

		// Print a Log In message to the screen

		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

		// Find the element that's ID attribute is 'account_logout' (Log Out)

		//driver.findElement(By.id("account_logout"));

		Log.info("Click action performed on Log out link");

		// Close the driver

		driver.quit();

		Log.info("Browser closed");

	}

}
