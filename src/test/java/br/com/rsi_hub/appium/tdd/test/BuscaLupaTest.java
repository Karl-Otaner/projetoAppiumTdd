package br.com.rsi_hub.appium.tdd.test;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsi_hub.appium.tdd.acoes.Touch;
import br.com.rsi_hub.appium.tdd.driver.DriverFactory;
import br.com.rsi_hub.appium.tdd.screenFactory.BuscaProdutoLupaScreen;
import br.com.rsi_hub.appium.tdd.utilitarios.Relatorio;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BuscaLupaTest {

	public static AndroidDriver<MobileElement> driver;

	public BuscaProdutoLupaScreen buscaLupa;
	public Touch touch;
	private ExtentReports extent;
	private ExtentTest logger;

	@BeforeMethod
	public void iniciarApp() throws MalformedURLException {
		driver = DriverFactory.createDriver();
		buscaLupa = PageFactory.initElements(driver, BuscaProdutoLupaScreen.class);
		touch = new Touch(driver);

	}

	@BeforeTest
	public void relatorio() {
		extent = Relatorio.setExtent();
	}

	@Test
	public void deveBuscarProdutoPelaLupa() throws Exception {
		logger = Relatorio.setUp("buscarProdutoExistentePelaLupa");

		buscaLupa.clicaSearch();
		buscaLupa.clicaLupa();
		touch.scroll();

		assertTrue(driver.getPageSource().contains("HP STREAM - 11-D020NR LAPTOP"));

	}

	@Test
	public void deveBuscarProdutoPelaLupaQueNaoExiste() throws InterruptedException {
		logger = Relatorio.setUp("buscarProdutoInexistentePelaLupa");

		buscaLupa.produtoInexistente();
		buscaLupa.clicaLupa();
		Thread.sleep(1000);
		assertTrue(driver.getPageSource().contains("No results for"));

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
