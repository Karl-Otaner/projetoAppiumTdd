package br.com.rsi_hub.appium.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BuscaProdutoLupaPage {
	private WebDriver driver;

public void PageLupa (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		}

	@FindBy(how= How.ID, using ="com.Advantage.aShopping:id/editTextSearch")
	private WebElement clicaSearch;
	
	@FindBy(how= How.ID, using ="com.Advantage.aShopping:id/imageViewSearch")
	private WebElement clicaLupa;
	
	public void clicaSearch() {
		clicaSearch.click();
		clicaSearch.sendKeys("laptops");
		
	}
	
	public void clicaLupa() {
		clicaLupa.click();
	}
	
	
	
	
	
	
}
