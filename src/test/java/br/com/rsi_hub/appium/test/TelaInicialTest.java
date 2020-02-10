package br.com.rsi_hub.appium.test;

import java.net.MalformedURLException;

import org.aspectj.lang.annotation.After;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

import br.com.rsi_hub.appium.PageFactory.LoginPage;
import br.com.rsi_hub.appium.PageFactory.ProdutoTelaPrincipalPage;
import br.com.rsi_hub.appium.driver.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TelaInicialTest {

	public AndroidDriver<MobileElement> driver;
	public ProdutoTelaPrincipalPage telaPrincipal;
	private LoginPage login;

	@BeforeMethod
	public void iniciarApp() throws MalformedURLException {
		driver = DriverFactory.createDriver();
		telaPrincipal = new ProdutoTelaPrincipalPage(driver);
		login = new LoginPage(driver);
	}

//	@Test
	public void deveBuscaProdutoTelaPrincipal() {

		telaPrincipal.clicaTable();
		telaPrincipal.escolherTablet();
		Assert.assertTrue(driver.getPageSource().contains("HP PRO TABLET 608 G1"));

	}

	@Test
	public void deveAdicionarProdutoCarrinhoComMaisDeDezItens() throws Exception {

		login.cliqueMenu();
		login.cliqueLogin();
		login.usuarioFixo();
		login.senhaFixa();
		login.login();
//		login.cliqueMenu();
		
		telaPrincipal.clicaTable();
		telaPrincipal.escolherTablet();
		
		telaPrincipal.clicarQuantidade();
		telaPrincipal.digitarQuantidade("11");
//		telaPrincipal.quantidadeApplay();
		
		

	}

	  @AfterMethod
	public void fecharApp() {
		DriverFactory.killDriver();
	}

}
