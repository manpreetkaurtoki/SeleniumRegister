package demoecom;

import org.testng.annotations.Test;

import pageclasses.HomePage;
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
	@Test
	public void setFilter() throws InterruptedException
	{
		SigninPage signInObj = new SigninPage();
		signInObj.enterUsername("standard_user");
		signInObj.enterPassword("secret_sauce");
		signInObj.clickLogin();
		
		HomePage homeObj= new HomePage();
		homeObj.chooseFilter(2);
		Thread.sleep(8000);
		homeObj.addCheapestProductToCart();
	
	}
	
}
