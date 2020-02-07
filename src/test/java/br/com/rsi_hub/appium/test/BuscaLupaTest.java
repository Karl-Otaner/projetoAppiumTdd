package br.com.rsi_hub.appium.test;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsi_hub.appium.PageFactory.BuscaProdutoLupaPage;
import br.com.rsi_hub.appium.acoes.Touch;
import br.com.rsi_hub.appium.driver.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class BuscaLupaTest {

	
	 private static AndroidDriver<MobileElement> driver;
	 
	 public BuscaProdutoLupaPage buscaLupa;
	 public Touch touch;
	 
	 @BeforeMethod
	 public void iniciarApp() throws MalformedURLException{
		 driver = DriverFactory.createDriver();
		 buscaLupa = PageFactory.initElements(driver, BuscaProdutoLupaPage.class);
		 touch = new Touch(driver);
		 
	 }
	 
	 @Test
	 public void deveBuscarProdutoPelaLupa() throws InterruptedException {
		buscaLupa.clicaSearch();
		buscaLupa.clicaLupa();
		touch.scroll();
		 
	 }
	 
	 @AfterMethod
	 public void fecharApp() {
		  DriverFactory.killDriver();
	  }

	 
	 
}
