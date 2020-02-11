package br.com.rsi_hub.appium.tdd.utilitarios;

import java.io.IOException;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Relatorio {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public static ExtentReports setExtent() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/target/Report.html");
		htmlReporter.config().setDocumentTitle("Relatorio de Automacao Mobile"); // Titulo do report
		htmlReporter.config().setReportName("Relatorio Funcional"); // Nome do report
		htmlReporter.config().setTheme(Theme.DARK); // Seleciona o tema
		htmlReporter.config().setProtocol(Protocol.HTTP);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		return extent;
	}
	//Fechar relatorio
	public static void closeReport(ExtentReports extent) {
		extent.flush();
	}
	
	// Cria o Report 
		public static ExtentTest setUp(String report) {
		logger = extent.createTest(report);
		return logger;
	}
		
		/* Verifica se o teste passou, falhou ou pulou e tira screenshot */
		public static void tearDown(ITestResult result, ExtentTest test, AndroidDriver<MobileElement> driver) throws IOException {
			String screenshotPath = ScreenShort.getScreenshot(driver);
			if (result.getStatus() == ITestResult.FAILURE) {
				test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); 
				test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); 
				test.addScreenCaptureFromPath(screenshotPath); 

			} else if (result.getStatus() == ITestResult.SKIP) {
				test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
				test.addScreenCaptureFromPath(screenshotPath); 

			} else if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
				test.addScreenCaptureFromPath(screenshotPath);
			}
		}


}
