package br.com.rsi_hub.appium.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProdutoTelaPrincipalPage {

	private WebDriver driver;
	private WebElement element;

	public void PageAdvance (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.ImageView")
	private WebElement clicaTablet;
	
	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@content-desc=\"Tablets\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[3]/android.widget.ImageView")
	private WebElement escolherTablet;
	
	public void clicaTable() {
		clicaTablet.click();
	}
	
	public void escolherTablet() {
		escolherTablet.click();
	}
	
	
}
