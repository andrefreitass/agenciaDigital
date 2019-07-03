package suporte;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

public class Log4j_Logging_TC {

	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


	public static void main(String[] args) throws Exception {

// Provide Log4j configuration settings
		DOMConfigurator.configure("/home/andre/Developer/work/PortalIdeiaDataPoolExcel/src/test/java/br/com/portalIdeia/log4j.xml");

		Log.startTestCase("Selenium_Test_001");


		Log.info(" Excel sheet opened");

		Log.info("New driver instantiated");

		Log.info("Implicit wait applied on the driver for 10 seconds");



		Log.info("Web application launched");


		System.out.println("Login Successfully, now it is the time to Log Off buddy.");

		Log.info("Click action is perfomred on Log Out link");



		Log.info("Browser closed");


		Log.endTestCase("Selenium_Test_001");

	}

}
