package br.com.rsi_hub.appium.tdd.PageFactory;

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
	
	@FindBy(how = How.XPATH, using = "//*[@text='HEADPHONES']")
	private WebElement escolherHead;
	
	
	@FindBy(how = How.XPATH, using = "//*[@text='BOSE SOUNDLINK AROUND-EAR WIRELESS HEADPHONES II']")
	private WebElement ProdutoInvalido;
	
	@FindBy(how = How.XPATH, using = "//*[@text='SOLD OUT']")
	private WebElement semSaldo;
	

	
	public void clicaTable() {
		wait.until(ExpectedConditions.visibilityOf(clicaTablet)).click();
		
	}
	public void escolherHead() {
		wait.until(ExpectedConditions.visibilityOf(escolherHead)).click();
	}
	
	public void escolherTablet() {
		wait.until(ExpectedConditions.visibilityOf(escolherTablet)).click();
	}
	
	public void ProdutoInvalido() {
		wait.until(ExpectedConditions.visibilityOf(ProdutoInvalido)).click();
		
	}
	
}
