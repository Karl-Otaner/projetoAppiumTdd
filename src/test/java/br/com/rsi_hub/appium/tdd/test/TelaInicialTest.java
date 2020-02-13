package br.com.rsi_hub.appium.tdd.test;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsi_hub.appium.tdd.driver.DriverFactory;
import br.com.rsi_hub.appium.tdd.screenFactory.LoginScreen;
import br.com.rsi_hub.appium.tdd.screenFactory.ProdutoTelaPrincipalScreen;
import br.com.rsi_hub.appium.tdd.utilitarios.Relatorio;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TelaInicialTest {

	public AndroidDriver<MobileElement> driver;
	public ProdutoTelaPrincipalScreen telaPrincipal;
	private LoginScreen login;
	private ExtentReports extent;
	private ExtentTest logger;

	@BeforeMethod
	public void iniciarApp() throws MalformedURLException {
		driver = DriverFactory.createDriver();
		telaPrincipal = new ProdutoTelaPrincipalScreen(driver);
		login = new LoginScreen(driver);
	}

	@BeforeTest
	public void relatorio() throws MalformedURLException {
		extent = Relatorio.setExtent();
	}

	@Test
	public void deveBuscaProdutoTelaPrincipal() throws MalformedURLException {
		telaPrincipal.clicaTable();
		telaPrincipal.escolherTablet();
		Assert.assertTrue(driver.getPageSource().contains("HP PRO TABLET 608 G1"));
		logger = Relatorio.setUp("buscaProdutoTelaPrincipal");

	}

	@Test
	public void deveBuscarProdutoSemSaldo() throws Exception {
		logger = Relatorio.setUp("buscaProdutoTelaPrincipalComFalha");

		
		telaPrincipal.escolherHead();
		telaPrincipal.ProdutoInvalido();
		Assert.assertTrue(driver.getPageSource().contains("SOLD OUT"));

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
