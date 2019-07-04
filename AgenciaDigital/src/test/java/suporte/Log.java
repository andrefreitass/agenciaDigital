package suporte;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Log {

// Initialize Log4j logs
	static String configFilename = "C:\\Users\\F642250\\Documents\\automacao\\AgenciaDigital\\AgenciaDigital\\src\\test\\java\\suporte\\log4j.properties";

	@BeforeClass
	public static void getlog() {
		PropertyConfigurator.configure(configFilename);
		startTestCase("Iniciando Caso Teste");
	}

	@AfterClass
	public static void encerraCasoTeste() {
		endTestCase(configFilename);
	}

	private static Logger Log = Logger.getLogger(Log.class.getName());//

	// This is to print log for the beginning of the test case, as we usually run so
	// many test cases as a test suite

	public static void startTestCase(String sTestCaseName) {

		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$                " + sTestCaseName + "      $$$$$$$$$$$$$$$$$$$$$$$$");
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");

	}

	// This is to print log for the ending of the test case
	public static void endTestCase(String sTestCaseName) {

		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
		Log.info("XXXXXXXXXXXXXXX      " + "------ENCERRANDO CASO DE TESTE------" + "      XXXXXXXXXXXXXXX");
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
	}

	// Need to create these methods, so that they can be called

	public static void info(String message) {

		Log.info(message);

	}

	public static void warn(String message) {

		Log.warn(message);

	}

	public static void error(String message) {

		Log.error(message);

	}

	public static void fatal(String message) {

		Log.fatal(message);

	}

	public static void debug(String message) {

		Log.debug(message);

	}

}