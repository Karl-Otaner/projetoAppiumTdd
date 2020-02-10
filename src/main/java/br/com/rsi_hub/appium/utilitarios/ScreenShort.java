package br.com.rsi_hub.appium.utilitarios;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShort {

	public static String getScreenshot(WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/screenTela/" + System.currentTimeMillis() + ".png";

		File destination = new File(path);
		
		try {

		FileUtils.copyFile(src , destination);
		
		}
		catch (IOException e) {
			
			System.out.println("Captura Falhou" + e.getMessage());
		}
		return path;

	}
}
