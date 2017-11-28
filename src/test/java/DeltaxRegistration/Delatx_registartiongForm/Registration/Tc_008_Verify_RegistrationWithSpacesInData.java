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

public class Tc_008_Verify_RegistrationWithSpacesInData extends TestBase {
	
	
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
		
		
		String dataset[][] = getData("deltax_data", "SpaceData");
		
		return dataset;
		
		
		
	}
	
	
	@Test(dataProvider = "testData")
	public void verify_RegistrationWithSpacesInData(String fname,String lname,String uname,String password ,String c_password,String dep,String ename,String contactNumber )
	{
		log("==============  Starting Tc_008_Verify_RegistrationWithSpacesInData===============");
		
		try{
		register = new RegistrationForm(driver);
		log("Filling user details where spaces are presemt in username and password");
		register.registerUser(fname, lname, uname, password, dep, c_password, ename, contactNumber);
		log("Submitting form");
		register.submitForm();
		takeScreenshot("registration_with_valid_data");
		}
		catch (InvalidElementStateException e) {
			
			takeScreenshot("Fail_Tc_008_Verify_RegistrationWithSpacesInData");
			Assert.assertEquals(true, register.invalid_data_title.isDisplayed());
			
		}
		log("==============  Finished Tc_008_Verify_RegistrationWithSpacesInData===============");
		
		
		
		
		
	}
	
	@AfterTest
	public void endTest()
	{
		
		closeBrowser();
		
		
	}
	

}
