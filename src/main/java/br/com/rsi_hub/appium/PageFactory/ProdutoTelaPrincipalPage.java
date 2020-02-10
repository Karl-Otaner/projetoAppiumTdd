package br.com.rsi_hub.appium.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProdutoTelaPrincipalPage {

	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;

	

	public ProdutoTelaPrincipalPage(AndroidDriver<MobileElement> driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 20);
		
		}
	
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.ImageView")
	private WebElement clicaTablet;
	
	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@content-desc=\"Tablets\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[3]/android.widget.ImageView")
	private WebElement escolherTablet;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/linearLayoutProductQuantity")
	private WebElement clicarQuantidade;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewProductQuantity")
	private WebElement digitarQuantidade;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewApply")
	private WebElement quantidadeApply;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonProductAddToCart")
	private WebElement adicionarCarrinho;
	
	
	
	public void clicaTable() {
		wait.until(ExpectedConditions.visibilityOf(clicaTablet)).click();
		
	}
	
	public void escolherTablet() {
		wait.until(ExpectedConditions.visibilityOf(escolherTablet)).click();
	}
	
	
	
	public void clicarQuantidade() {
		wait.until(ExpectedConditions.visibilityOf(clicarQuantidade)).click();
	}
	
	public void digitarQuantidade(String quantidade) throws InterruptedException {
//		digitarQuantidade.clear();
		digitarQuantidade.sendKeys(quantidade);
		
		
	}
	
	
	public void quantidadeApplay() {
		wait.until(ExpectedConditions.visibilityOf(quantidadeApply)).click();
		
	}
	
	public void adicionarCarrinho() {
		wait.until(ExpectedConditions.visibilityOf(adicionarCarrinho)).click();
		
	}
	
}
