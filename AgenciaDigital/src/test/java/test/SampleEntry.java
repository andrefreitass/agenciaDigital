package test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class SampleEntry {

	public static void main(String[] args) {

		BasicConfigurator.configure();
		Logger OurLogger = LogManager.getLogger("OurLogger");

		// create a FileAppender object and
		// associate the file name to which you want the logs
		// to be directed to.
		// You will also have to set a layout also, here
		// We have chosen a SimpleLayout
		FileAppender fileAppender = new FileAppender();
		fileAppender.setFile("logfile.txt");
		fileAppender.setLayout(new SimpleLayout());

		// Add the appender to our Logger Object.
		// from now onwards all the logs will be directed
		// to file mentioned by FileAppender
		OurLogger.addAppender(fileAppender);
		fileAppender.activateOptions();

		// lets print some log 10 times
		int x = 0;
		while (x < 11) {
			OurLogger.debug("This is just a log that I want to print " + x);
			x++;
		}

	}
}