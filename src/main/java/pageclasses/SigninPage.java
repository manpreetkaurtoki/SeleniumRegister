package pageclasses;

import org.openqa.selenium.By;

import utils.UiActionUtils;

public class SigninPage {
	By usernameInput = By.id("user-name");
	By passwordinput = By.id("password");
	By loginBtn = By.id("login-button");
	
	public void enterUsername(String username)
	{
		UiActionUtils.enterText(usernameInput, username);
	}
	public void enterPassword(String password)
	{
		UiActionUtils.enterPassword(passwordinput, password);
	}
	
	public void clickLogin()
	{
		UiActionUtils.click(loginBtn, "Login button");
	}

}
