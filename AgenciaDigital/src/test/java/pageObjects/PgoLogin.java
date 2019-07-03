package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PgoLogin extends GenericsPgo {

	@FindBy(id = "username")
	public WebElement CMP_LOGIN;

	@FindBy(id = "password")
	public WebElement CMP_SENHA;
	
	@FindBy(id = "kc-login")
	public WebElement BTN_ENTRAR;
	
	@FindBy(css = ".kc-feedback-text")
	public WebElement MSG_ERRO;
	
}
