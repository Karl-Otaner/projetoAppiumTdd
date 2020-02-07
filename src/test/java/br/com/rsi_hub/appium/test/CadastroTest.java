package br.com.rsi_hub.appium.test;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;

import br.com.rsi_hub.appium.PageFactory.CadastroPage;
import br.com.rsi_hub.appium.PageFactory.LoginPage;
import br.com.rsi_hub.appium.driver.DriverFactory;
import br.com.rsi_hub.appium.excel.MassaDeDados;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CadastroTest {

	public AndroidDriver<MobileElement> driver;
	private LoginPage login;
	private CadastroPage cadastro;
	private MassaDeDados massa;
	private WebDriverWait wait;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		driver = DriverFactory.createDriver();
		login = new LoginPage(driver);
		cadastro = new CadastroPage(driver);
		massa = new MassaDeDados();
		wait = new WebDriverWait(driver, 2);

	}

	@Test
	public void deveFazerCadastroDeNovoUsuario() throws Exception {
		login.cliqueMenu();
		login.cliqueLogin();
		login.cliqueNovaConta();
		cadastro.digiteNome(massa.digiteNome());
		cadastro.digiteEmail(massa.digiteEmail());
		cadastro.digiteSenha(massa.digiteSenha());
		cadastro.confirmarSenha(massa.confirmarSenha());
		cadastro.digitePrimeiroNome(massa.digitePrimeiroNome());
		cadastro.digiteUltimoNome(massa.digiteUltimoNome());
		cadastro.digiteTelefone(massa.digiteTelefone());
		cadastro.escolhaPais(massa.escolhaPais());
		cadastro.digiteEstado(massa.digiteEstado());
		cadastro.digiteEndereco(massa.digiteEndereco());
		cadastro.digiteCidade(massa.digiteCidade());
		cadastro.digiteCep(massa.digiteCep());
		cadastro.clicarRegistro();

		Thread.sleep(2000);
		login.cliqueMenu();
		String confirmar = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser")).getText();
		Assert.assertTrue(confirmar.contains(massa.digiteNome()));

	}

	@AfterMethod
	public void fecharApp() {
		DriverFactory.killDriver();
	}

}
