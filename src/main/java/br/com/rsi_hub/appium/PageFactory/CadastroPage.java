package br.com.rsi_hub.appium.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class CadastroPage {

	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;
	TouchAction action;

	public CadastroPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 20);
		action =  new TouchAction(driver);
	}

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextUserName']/child::*[1]")
	private WebElement nome;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextEmail']/child::*[1]")
	private WebElement email;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPassword']/child::*[1]")
	private WebElement senha;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextConfirmPassword']/child::*[1]")
	private WebElement confirmeSenha;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextFirstName']/child::*[1]")
	private WebElement primeiroNome;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLastName']/child::*[1]")
	private WebElement ultimoNome;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPhoneNumber']/child::*[1]")
	private WebElement telefone;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewCountries")
	private WebElement pais;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextState']/child::*[1]")
	private WebElement estado;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextStreet']/child::*[1]")
	private WebElement endereco;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextCity']/child::*[1]")
	private WebElement cidade;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextZip']/child::*[1]")
	private WebElement cep;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonRegister")
	private WebElement botaoRegistro;

	public void digiteNome(String digiteNome) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(nome)).click();
		nome.sendKeys(digiteNome);
	}

	public void digiteEmail(String digiteEmail) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(email)).click();
		email.sendKeys(digiteEmail);
	}

	public void digiteSenha(String digiteSenha) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(senha)).click();
		senha.sendKeys(digiteSenha);
	}

	public void confirmarSenha(String confirmarSenha) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(confirmeSenha)).click();
		confirmeSenha.sendKeys(confirmarSenha);
	}

	public void digitePrimeiroNome(String digitePrimeiroNome) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(primeiroNome)).click();
		primeiroNome.sendKeys(digitePrimeiroNome);
	}

	public void digiteUltimoNome(String digiteUltimoNome) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(ultimoNome)).click();
		ultimoNome.sendKeys(digiteUltimoNome);
	}

	public void digiteTelefone(String digiteTelefone) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(telefone)).click();
		telefone.sendKeys(digiteTelefone);
		 action.press(PointOption.point(860, 1400)).moveTo(PointOption.point(814, 400)).release().perform();
	}

	public void escolhaPais(String escolhaPais) throws Exception {

		wait.until(ExpectedConditions.visibilityOf(pais)).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ escolhaPais + "\").instance(0))")
				.click();

	}

	public void digiteEstado(String digiteEstado) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(estado)).click();
		estado.sendKeys(digiteEstado);
	}

	public void digiteEndereco(String digiteEndereco) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(endereco)).click();
		endereco.sendKeys(digiteEndereco);
	}

	public void digiteCidade(String digiteCidade) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(cidade)).click();
		cidade.sendKeys(digiteCidade);
	}

	public void digiteCep(String digiteCep) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(cep)).click();
		cep.sendKeys(digiteCep);
		  action.press(PointOption.point(668, 1030)).moveTo(PointOption.point(672, 387)).release().perform();
	}

	public void clicarRegistro() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(botaoRegistro)).click();
	
	}

}
