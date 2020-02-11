package br.com.rsi_hub.appium.tdd.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;
	

	public static AndroidDriver<MobileElement> createDriver() throws MalformedURLException {
		
		if(driver ==null) {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.Advantage.aShopping");
	    desiredCapabilities.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");
	    desiredCapabilities.setCapability("unicodeKeyboard", true);
	    desiredCapabilities.setCapability("resetKeyboard", true);


	    
	    driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}	
		return driver;
		
}
	
	public static  void killDriver() {
		if(driver !=null) {//se já tiver algum driver
			driver.quit();
			driver = null; //zerar o driver
			//O driver será zerado para uma proxima vez que algume pedir esse driver, depois que essa instacia for morta
			//O factory criará um nova instancia;
			//Isso evita que venha um driver que já está com a seccão encerrado, causando problemas com o teste.
		}
	}

}
