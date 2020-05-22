package com.usa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.usa.basepage.SupperClass;

public class SeleniumUtil extends SupperClass {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	static Workbook book;
	static Sheet sheet;
	static WebDriver driver;

	@SuppressWarnings("static-access")
	public SeleniumUtil(WebDriver driver) {
		this.driver = driver;
	}

	public static String TESTDATA_SHEET_PATH = "/Users/mohammedalam/eclipse-workspace/DAR-E2E/Test cases/Test_Cases_Automation.xlsx";

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static WebElement getExplicitWait(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
		return element1;
	}
	

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("MM.dd.yyyy-hh.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public static void drawBorder(WebElement webelement, String color) {
		WebElement element_node = webelement;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid " + color + "'", element_node);
	}

	public static void javScriptClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	@SuppressWarnings("deprecation")
	public static void waitThenClick(WebDriver driver, WebElement element) {
		try {
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(5, TimeUnit.SECONDS)
					.withTimeout(30, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.elementToBeClickable(element));
			if (element.isDisplayed()) {
				element.click();
			}
		} catch (TimeoutException toe) {
			toe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unused", "deprecation" })
	public static void customWait() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				// Wait for the condition
				.withTimeout(60, TimeUnit.SECONDS)
				// which to check for the condition with interval of 5 seconds.
				.pollingEvery(15, TimeUnit.SECONDS)
				// Which will ignore the NoSuchElementException
				.ignoring(NoSuchElementException.class);
	}

	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public static void scrollView(String Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public static void jsClick(String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", locator);
	}

	public static String threeDaysBefore() {
		String threeDaysBefore = "";
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, -3);
		Date before = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		threeDaysBefore = formatter.format(before);
		return threeDaysBefore;
	}

}