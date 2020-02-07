package br.com.rsi_hub.appium.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	
	AndroidDriver driver;
	private WebDriverWait wait;
	
	
	public LoginPage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement cliqueMenu;
	
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement cliqueLogin;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewSingUpToday")
	private WebElement cliqueNovaConta;
	
	
	public void cliqueMenu() {
//		wait.until(ExpectedConditions.elementToBeClickable(cliqueMenu)).click();
		cliqueMenu.click();
		
	}
	
	public void cliqueLogin() {
		cliqueLogin.click();
		
	}
	
	public void cliqueNovaConta() {
		cliqueNovaConta.click();
		
	}
	
	
	
	

}
