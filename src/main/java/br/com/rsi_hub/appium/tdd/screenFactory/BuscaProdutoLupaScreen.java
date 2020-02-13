package br.com.rsi_hub.appium.tdd.screenFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuscaProdutoLupaScreen {
	private WebDriver driver;
	private WebDriverWait wait;

	public void PageLupa(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 20);

	}

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/editTextSearch")
	private WebElement clicaSearch;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewSearch")
	private WebElement clicaLupa;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewProductName")
	private WebElement produtoEscolhido;

	public void clicaSearch() {
		clicaSearch.click();
		clicaSearch.sendKeys("laptops");

	}

	public void clicaLupa() {
		clicaLupa.click();
	}

	public void produtoInexistente() {
		clicaSearch.click();
		clicaSearch.sendKeys("carro");
	}

}
