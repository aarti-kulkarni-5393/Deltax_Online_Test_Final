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

public class TC_001_VerifyRegistrationWithSameEmailID extends TestBase{
	
	RegistrationForm register;
	@BeforeTest
	public void setup() throws Exception
	{
		
		init();
		
	}
	
	@DataProvider(name ="testData")
	public String[][]getData() throws IOException
	{
		
		
		String dataset[][] = getData("deltax_data", "RegisterData_withSameEmailData");
		
		return dataset;
		
		
		
	}
	
	
	@Test(dataProvider = "testData")
	public void verifyRegistrationWithSameEmailID(String fname,String lname,String uname,String password ,String c_password,String dep,String ename,String contactNumber )
	{
		log("==============  Starting TC_001_VerifyRegistrationWithSameEmailID===============");
		
		try{
		register = new RegistrationForm(driver);
		log("Register user with userId data");
		log("Filling  user details where  already used EmailId is given and it is:"+ename);
		register.registerUser(fname, lname, uname, password, dep, c_password, ename, contactNumber);
		log("Submitting Registration Form");
		register.submitForm();
		Assert.assertEquals(true, register.invalid_data_title.isDisplayed());
		takeScreenshot("TC_001_VerifyRegistrationWithSameEmailID");
		}
		catch (InvalidElementStateException e) {
			
			takeScreenshot("Fail_TC_001_VerifyRegistrationWithSameEmailID");
			
		}
		
		
		
		log("==============  Finished TC_001_VerifyRegistrationWithSameEmailID===============");
		
		
	}
	
	@AfterTest
	public void endTest()
	{
		
		closeBrowser();
		
		
	}

}
