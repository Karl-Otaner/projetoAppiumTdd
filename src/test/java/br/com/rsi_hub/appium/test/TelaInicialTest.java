package br.com.rsi_hub.appium.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.aspectj.lang.annotation.After;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

import br.com.rsi_hub.appium.PageFactory.LoginPage;
import br.com.rsi_hub.appium.PageFactory.ProdutoTelaPrincipalPage;
import br.com.rsi_hub.appium.driver.DriverFactory;
import br.com.rsi_hub.appium.utilitarios.Relatorio;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TelaInicialTest {

	public AndroidDriver<MobileElement> driver;
	public ProdutoTelaPrincipalPage telaPrincipal;
	private LoginPage login;
	private ExtentReports extent;
	private ExtentTest logger;

	@BeforeMethod
	public void iniciarApp() throws MalformedURLException {
		driver = DriverFactory.createDriver();
		telaPrincipal = new ProdutoTelaPrincipalPage(driver);
		login = new LoginPage(driver);
	}

	@BeforeTest
	public void relatorio() {
		extent = Relatorio.setExtent();
	}

	@Test
	public void deveBuscaProdutoTelaPrincipal() {
		telaPrincipal.clicaTable();
		telaPrincipal.escolherTablet();
		Assert.assertTrue(driver.getPageSource().contains("HP PRO TABLET 608 G1"));
		logger = Relatorio.setUp("buscaProdutoTelaPrincipal");

	}

	@Test
	public void deveAdicionarProdutoCarrinhoComMaisDeDezItens() throws Exception {
		logger = Relatorio.setUp("buscaProdutoTelaPrincipalComFalha");

		login.cliqueMenu();
		login.cliqueLogin();
		login.usuarioFixo();
		login.senhaFixa();
		login.login();

		telaPrincipal.clicaTable();
		telaPrincipal.escolherTablet();

		telaPrincipal.clicarQuantidade();
		telaPrincipal.digitarQuantidade("11");
		telaPrincipal.quantidadeApplay();
		telaPrincipal.adicionarCarrinho();

		assertTrue(driver.getPageSource().contains("10"));


	}

	@AfterMethod
	public void fecharApp(ITestResult result) throws Exception {
		Relatorio.tearDown(result, logger, driver);
		Relatorio.closeReport(extent);
		DriverFactory.killDriver();

	}

	@AfterTest
	public void finalizaRelatorio() {
		extent.flush();
	}

}
