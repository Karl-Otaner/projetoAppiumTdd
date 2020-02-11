package br.com.rsi_hub.appium.tdd.PageFactory;

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
	
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText")
	private WebElement usuarioFixo;
	
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText")
	private WebElement senhaFixa;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonLogin")
	private WebElement botaoLogin;
	
	
	
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
	public void usuarioFixo()  {
		usuarioFixo.sendKeys("Karl_Otaner");
	}
	
	public void senhaFixa()  {
		senhaFixa.sendKeys("Aa123456");
	}
	
	public void login() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(botaoLogin)).click();
	}
	
	
	
	

}
