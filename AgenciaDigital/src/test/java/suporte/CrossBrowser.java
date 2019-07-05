package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class CrossBrowser extends Log {
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	protected static ThreadLocal<SoftAssert> soft = new ThreadLocal<>();
	protected static ThreadLocal<String> parallelDriver = new ThreadLocal<>();
	protected static ThreadLocal<String> properties = new ThreadLocal<>();

	private DesiredCapabilities cap;
	private String URL = "https://agenciadigital.des.caixa:8002/siavl-web/index.html#!/";

	/**
	 * Metodo para retornar o driver conforme o browser informado na suite
	 * 
	 * @param browser
	 * @throws Exception
	 */
	public void defineBrowser(String navegador) {
		if (navegador.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\F642250\\Documents\\automacao\\AgenciaDigital\\AgenciaDigital\\src\\test\\java\\drivers\\chromedriver.exe");
			driver.set(new ChromeDriver());

		} else if (navegador.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\F642250\\Documents\\automacao\\AgenciaDigital\\AgenciaDigital\\src\\test\\java\\drivers\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			cap = DesiredCapabilities.firefox();
			FirefoxOptions opts = new FirefoxOptions();
			//opts.addArguments("-private");
			//opts.setAcceptInsecureCerts(true);
			//cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, opts);
			driver.set(new FirefoxDriver(opts));
		}
		acessaAplicacao();
	}

	private void acessaAplicacao() {
		driver.get().manage().deleteAllCookies();
		driver.get().get(URL);
		if (URL.contains("https") && driver.get().toString().contains("InternetExplorer")) {
			driver.get().navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		driver.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
	}

	//@AfterMethod
	public void finalizaBrowser() {
		driver.get().quit();
		Log.info("Encerrando Navegador");
	}

}