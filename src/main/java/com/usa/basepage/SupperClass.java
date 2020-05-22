package com.usa.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.usa.utility.SeleniumUtil;

public class SupperClass {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;

	public SupperClass() { // basetest  parantestest
		logger = Logger.getLogger("QA Testing"); // Added logger
		PropertyConfigurator.configure("Log4j.properties");// Added logger
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/usa/config/Config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browser = prop.getProperty("browser");
		// If the browser is Fire-fox, then do this
		if (browser.equalsIgnoreCase("Firefox")) {
			logger.info("******** I am a firefox browser*********");
			System.setProperty("webdriver.gecko.driver", "/Users/mohammedalam/geckodriver");
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			System.out.println("getFirefoxDriver Method is running on Thread :: " + Thread.currentThread().getId());
			driver = new FirefoxDriver();
			// If browser is IE, then do this

		} else if (browser.equalsIgnoreCase("IE")) {
			logger.info("******** I am a ie browser*********");
			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			System.out.println("getIEDriver Method is running on Thread : " + Thread.currentThread().getId());
			driver = new InternetExplorerDriver();

		} else if (browser.equalsIgnoreCase("Edge")) {
			logger.info("******** I am a edge browser*********");
			System.setProperty("webdriver.edge.driver", "./Driver/MicrosoftWebDriver.exe");
			System.out.println("GetEdgeMethod is running on Thread : " + Thread.currentThread().getId());
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			logger.info("******** I am a safari browser*********");
			System.out.println("getSafariDriver Method is running on Thread : " + Thread.currentThread().getId());
			driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			logger.info("******** I am a Chrome browser*********");
			System.setProperty("webdriver.chrome.driver", "/Users/mohammedalam/chromedriver");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			System.out.println("getChormeDriver Method is running on Thread : " + Thread.currentThread().getId());
			driver = new ChromeDriver();
		} else if (browser.equals("headless")) {
			logger.info("******** I am a headless browser*********");
			System.setProperty("webdriver.chrome.driver", "/Users/mohammedalam/chromedriver");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
					"--ignore-certificate-errors", "--silent");
			driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(SeleniumUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(SeleniumUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));
	}

	public static void InitializeCucumberBDD() {
		logger.info("******** I am a chrome browser *********");
		System.setProperty("webdriver.chrome.driver", "/Users/mohammedalam/chromedriver");
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.out.println(" getChormeDriver Method is running on Thread : " + Thread.currentThread().getId());
		driver = new ChromeDriver();
		logger.info("******** I am maximaize the browser *********");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(SeleniumUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(SeleniumUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
}
