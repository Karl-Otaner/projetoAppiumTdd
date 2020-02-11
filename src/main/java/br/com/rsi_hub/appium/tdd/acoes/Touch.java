package br.com.rsi_hub.appium.tdd.acoes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Touch {

	private TouchAction touch;
	private WebDriver driver;

	public Touch(AndroidDriver<MobileElement> driver2) {
		this.driver = driver2;
		this.touch = new TouchAction((PerformsTouchActions) this.driver);
	}

	public void scroll() throws InterruptedException {

		((FindsByAndroidUIAutomator<WebElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "HP STREAM - 11-D020NR LAPTOP" + "\").instance(0))")
				.click();

	}
}
