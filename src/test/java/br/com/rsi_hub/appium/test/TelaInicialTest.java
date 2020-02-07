package br.com.rsi_hub.appium.test;

import java.net.MalformedURLException;

import org.aspectj.lang.annotation.After;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

import br.com.rsi_hub.appium.PageFactory.ProdutoTelaPrincipalPage;
import br.com.rsi_hub.appium.driver.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TelaInicialTest {

	
	 private static AndroidDriver<MobileElement> driver;
	 
	 public ProdutoTelaPrincipalPage telaPrincipal;
	  
	 @BeforeMethod
	 public void iniciarApp() throws MalformedURLException{
		 driver = DriverFactory.createDriver();
		 telaPrincipal = PageFactory.initElements(driver, ProdutoTelaPrincipalPage.class);
		 
	 }

	  @Test
	  public void deveBuscaProdutoTelaPrincipal() {
	   
		  telaPrincipal.clicaTable();
		  telaPrincipal.escolherTablet();
	  }
	  
	  @AfterMethod
	  public void fecharApp() {
		  DriverFactory.killDriver();
	  }

	
}
