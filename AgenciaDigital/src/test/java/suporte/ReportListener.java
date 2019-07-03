package suporte;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;



public class ReportListener implements IInvokedMethodListener {

	private static WebDriver driver;
	static ThreadLocal<SoftAssert> soft = new ThreadLocal<>();
	private static ThreadLocal<String> steps = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		ReportListener.driver = driver;
	}

	public static void setAsserts(SoftAssert s) {
		soft.set(s);
	}

	public static void setSteps(String step){
		if(step.startsWith("CT")){
			step = "</ol></p><p><b>" + step + "</b><ol>";

		}else if(step.contains("FAILED") || step.contains("PASSED")){
			step = "</br>" + step + "</br>";
		
		}else{
			step = "<li>" +  step + "</li>";
		}
		steps.set(steps.get()+step);
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		steps.set(new String());
		System.gc();
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

		if (method.isTestMethod()) {
			//Allure.addDescription(steps.get() + "</ol></p>");
			soft.get().assertAll();
			if (!testResult.isSuccess()) {
				attachScreenshot();
			}
		}
	}

	private void attachScreenshot() {
		/**
		 * Browser
		 * */
		//Allure.addAttachment("Screenshot", new ByteArrayInputStream(FileUtils.readFileToByteArray(Screenshots.takeScreenShotAsFile())));
		/**
		 * Mobile
		 * */
		//Allure.addAttachment("ScreenShot-OnTestFail", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	}

}

