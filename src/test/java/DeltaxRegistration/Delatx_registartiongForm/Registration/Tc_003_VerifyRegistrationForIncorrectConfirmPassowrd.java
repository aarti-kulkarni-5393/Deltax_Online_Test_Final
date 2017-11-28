package DeltaxRegistration.Delatx_registartiongForm.Registration;

import java.io.IOException;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DeltaxRegistration.Delatx_registartiongForm.testBase.TestBase;
import DeltaxRegistration.Delatx_registartiongForm.uiActions.RegistrationForm;

public class Tc_003_VerifyRegistrationForIncorrectConfirmPassowrd extends TestBase {
	RegistrationForm register;
	@BeforeTest
	public void setup() throws Exception
	{
		
		init();
		
	}
	
	@DataProvider(name ="testData")
	public String[][]getData() throws IOException
	{
		
		
		String dataset[][] = getData("deltax_data", "InvalidconfirmPassword");
		
		return dataset;
		
		
		
	}
	
	
	@Test(dataProvider = "testData")
	public void verifyRegistrationForIncorrectConfirmPassowrd(String fname,String lname,String uname,String password ,String c_password,String dep,String ename,String contactNumber )
	{
		log("==============  Starting Tc_003_VerifyRegistrationForIncorrectConfirmPassowrd===============");
		
		try{
		register = new RegistrationForm(driver);
		log("Register user with Confrim password is wrong ");
		register.registerUser(fname, lname, uname, password, dep, c_password, ename, contactNumber);
		register.submitForm();
		
		takeScreenshot("Tc_003_VerifyRegistrationForIncorrectConfirmPassowrd");
		}
		catch (InvalidElementStateException e) {
			
			takeScreenshot("Fail_Tc_003_VerifyRegistrationForIncorrectConfirmPassowrd");
			Assert.assertEquals(true, register.invalid_data_title.isDisplayed());
			
		}
		
		
		
		log("==============  Finished Tc_003_VerifyRegistrationForIncorrectConfirmPassowrd===============");
		
		
	}
	
	@AfterTest
	public void endTest()
	{
		
		closeBrowser();
		
		
	}

}



