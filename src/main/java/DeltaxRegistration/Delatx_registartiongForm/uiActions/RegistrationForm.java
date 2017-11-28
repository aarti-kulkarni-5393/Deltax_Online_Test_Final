package DeltaxRegistration.Delatx_registartiongForm.uiActions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import DeltaxRegistration.Delatx_registartiongForm.testBase.TestBase;

public class RegistrationForm extends TestBase {
	
	WebDriver driver;
	
	public static final Logger log = Logger.getLogger(RegistrationForm.class.getName());
	
	@FindBy(how=How.NAME,using="first_name")
	WebElement first_name;
	@FindBy(how=How.NAME,using="last_name")
	WebElement last_name;
	@FindBy(how=How.NAME,using="user_name")
	WebElement user_name;
	@FindBy(how=How.NAME,using="department")
	WebElement department;
	@FindBy(how=How.NAME,using="user_password")
	WebElement user_password;
	@FindBy(how=How.NAME,using="confirm_password")
	WebElement confirm_password;
	@FindBy(how=How.NAME,using="email")
	WebElement email;
	@FindBy(how=How.NAME,using="contact_no")
	WebElement contact_no;      
	@FindBy(how=How.XPATH,using=".//button[contains(text(),'SUBMIT ')]")
	WebElement submit;
	@FindBy(how=How.XPATH,using=".//*[contains(text(),'Registration Form')]")
	WebElement title_Registration_Form;
	@FindBy(how=How.XPATH,using=".//*[contains(text(),'This value is not valid')]")
	public WebElement invalid_data_title;
	@FindBy(how=How.XPATH,using=".//*[contains(text(),'Thanks')]")
	public WebElement thanks_title;
	
	


	
	public RegistrationForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void registerUser(String fname,String lname,String uname,String password,String dep,String c_password,String ename,String contactNumber)
	{
		
		first_name.sendKeys(fname);
		log("entered first name and object is:"+first_name.toString());
		last_name.sendKeys(lname);
		log("entered last name and object is:"+last_name.toString());
		Select selectDepartment = new Select(department);
		selectDepartment.selectByVisibleText(dep);
		user_name.sendKeys(uname);
		log("entered user name and object is:"+user_name.toString());
		user_password.sendKeys(password);
		log("entered user password and object is:"+user_password.toString());
		confirm_password.sendKeys(c_password);
		log("entered confirm user password and object is:"+confirm_password.toString());
		email.sendKeys(ename);
		log("entered confirm email  and object is:"+email.toString());
		contact_no.sendKeys(contactNumber);
		log("entered contact no  and object is:"+contact_no.toString());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


	}
	
	public void submitForm()
	{
		
		if (submit.isEnabled()==true) {
			log("submit button is  enabled");
			submit.click();
			waitForElement(30, thanks_title);
			driver.navigate().refresh();
			
			
		}else {
			
		     log("submit button is not enabled");
		   
			
		}
		
		
	}
	
	
	
	
	
}
