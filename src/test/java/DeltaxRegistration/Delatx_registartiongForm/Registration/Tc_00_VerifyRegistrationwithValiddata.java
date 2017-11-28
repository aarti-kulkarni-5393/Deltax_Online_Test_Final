package DeltaxRegistration.Delatx_registartiongForm.Registration;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DeltaxRegistration.Delatx_registartiongForm.testBase.TestBase;
import DeltaxRegistration.Delatx_registartiongForm.uiActions.RegistrationForm;

public class Tc_00_VerifyRegistrationwithValiddata extends TestBase {
	
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
		
		
		String dataset[][] = getData("deltax_data", "Register_data");
		
		return dataset;
		
		
		
	}
	
	
	@Test(dataProvider = "testData")
	public void VerifyRegistrationwithValiddata(String fname,String lname,String uname,String password ,String c_password,String dep,String ename,String contactNumber )
	{
		log("==============  starting Tc_00_VerifyRegistrationwithValiddata===============");
		
		try{
		register = new RegistrationForm(driver);
		register.registerUser(fname, lname, uname, password, dep, c_password, ename, contactNumber);
		register.submitForm();
		
		takeScreenshot("registration_with_valid_data");
		}
		catch (InvalidElementStateException e) {
			
			takeScreenshot("Tc_Fail_VerifyRegistrationwithValiddata");
			
		}
		
		
		
		log("==============  finished Tc_00_VerifyRegistrationwithValiddata===============");
		
		
	}
	
	@AfterTest
	public void endTest()
	{
		
		closeBrowser();
		
		
	}
	
	
	

}
