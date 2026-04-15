package demoecom;

import org.testng.annotations.Test;

import pageclasses.SigninPage;

public class CheckoutTest extends Base {
	
	@Test
	public void loginTest()
	{
		SigninPage signInObj = new SigninPage();
		signInObj.enterUsername("standard_user");
		signInObj.enterPassword("secret_sauce");
		signInObj.clickLogin();
	}

}
