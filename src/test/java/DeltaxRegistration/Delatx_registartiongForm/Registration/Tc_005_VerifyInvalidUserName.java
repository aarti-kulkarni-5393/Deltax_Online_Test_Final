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

public class Tc_005_VerifyInvalidUserName extends TestBase{
	

	RegistrationForm register;
	
//	public static final Logger log = Logger.getLogger(Tc_00_VerifyRegistrationwithValiddata.class.getName());
	
	@BeforeTest
	public void setup() throws Exception
	{
		
		init();
		
	}
	
	@DataProvider(name ="testData")
	public String[][]getData() throws IOException
	{
		
		
		String dataset[][] = getData("deltax_data", "InvalidUsername");
		return dataset;
		
		
		
	}
	
	
	@Test(dataProvider = "testData")
	public void VerifyInvalidUserName(String fname,String lname,String uname,String password ,String c_password,String dep,String ename,String contactNumber )
	{
		log("==============  Starting Tc_005_VerifyInvalidUserName===============");
		
		try{
		register = new RegistrationForm(driver);
		log("username is inavlid");
		register.registerUser(fname, lname, uname, password, dep, c_password, ename, contactNumber);
		register.submitForm();
		takeScreenshot("registration_with_valid_data");
		}
		catch (InvalidElementStateException e) {
			
			takeScreenshot("Fail_Tc_Fail_VerifyRegistrationwithValiddata");
			Assert.assertEquals(true, register.invalid_data_title.isDisplayed());
			
		}
		
		
		
		log("==============  Finished Tc_005_VerifyInvalidUserName===============");
		
		
	}
	
	@AfterTest
	public void endTest()
	{
		
		closeBrowser();
		
		
	}

}
