package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

	static String driverPath = "C://Selenium//BrowserDrivers//";

	public static WebDriver Instance = null;

	public static WebDriver Initialize(String browser) {
		if (Instance == null) {
			System.out.println("Initializing Driver...");
			if (browser == "firefox")
				Instance = new FirefoxDriver();
			else if (browser == "chrome") {
				System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
				Instance = new ChromeDriver();
			} else if (browser == "IE") {
				System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
				Instance = new InternetExplorerDriver();
			}
		}
		return Instance;
	}

	public static void close() {
		System.out.println("Closing browser...");
		Instance.close();
		Instance = null;
	}
}
