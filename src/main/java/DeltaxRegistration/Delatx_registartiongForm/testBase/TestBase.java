package DeltaxRegistration.Delatx_registartiongForm.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import DeltaxRegistration.Delatx_registartiongForm.config.ConfigReader;
import DeltaxRegistration.Delatx_registartiongForm.customListner.WebListner;
import DeltaxRegistration.Delatx_registartiongForm.excelRead.ExcelRead;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
    public static WebDriver driver;
    public EventFiringWebDriver dir;
    public WebListner eventListner;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ITestResult result;
    ExcelRead excel;
    public ConfigReader config;


   public void readconfig() throws Exception
   {
	    config = new ConfigReader();
   }
    
	
     
    public void init() throws Exception
    {
    	readconfig();
    	//String log4jconfPath = "log4j.properties";
    	System.out.println(config.getData("log4j_properties"));
    	PropertyConfigurator.configure(config.getData("log4j_properties"));
    	System.out.println(config.getData("Browser"));
        selectBrowser(config.getData("Browser"));
    	getUrl(config.getData("login_url"));
    	extent = new ExtentReports(System.getProperty("user.dir")+config.getData("Extent_report_path"), true);
    }
    
	public void selectBrowser(String browser) throws Exception
	{
		if (browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", config.getData("chrome_path"));
			Map<String, Object> settings = new HashMap<String, Object>();
			settings.put("profile.default_content_setting_values.notifications", 2);
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("no-sandbox");
		    options.addArguments("disable-extensions");
		    options.addArguments("--start-maximized");
		    options.setExperimentalOption("prefs", settings);
		    log("creating browser object "+browser);
		    driver = new ChromeDriver(options);
		    // the following steps will initialize webeventListner -which listen events 
		    dir = new EventFiringWebDriver(driver);
		    //creating object of class which implements webdriverEventListner
		    eventListner = new WebListner();
		    //we need to have register webdriverEventListner in EventFiringDriver
		    dir.register(eventListner);
		    log("listner registeration done");
		   
			
		}
		else
		{
			
			System.setProperty("webdriver.gecko.driver",config.getData("Firefox_path"));
			Map<String, Object> settings = new HashMap<String, Object>();
			settings.put("profile.default_content_setting_values.notifications", 2);
			FirefoxProfile profile = new FirefoxProfile();
		    driver = new FirefoxDriver();
		}
		}
	
	public void getUrl(String URL)
	{  
		log("navigating to"+URL);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	
	
	public String[][] getData(String excelName,String sheetName) throws IOException
	{
		String currentUsersHomeDir = System.getProperty("user.dir");
		System.out.println(currentUsersHomeDir);
		excel = new ExcelRead(currentUsersHomeDir+"\\src\\main\\java\\DeltaxRegistration\\Delatx_registartiongForm\\data\\"+excelName+".xlsx");
		String data[][] = excel.getData(sheetName);
		return data;
	}
	

	
	public void waitForElement(int timeout,WebElement element)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public String takeScreenshot( String name)
	
	{
		
		if (name == "") {
			
			name = "blank";	
		}

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String currentUsersHomeDir = System.getProperty("user.dir");
	
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		log("screenshot has been taken for:"+name);
		// Destination file having name that we desired ,here it is date format so it will be unique 
		File destFile = new File(currentUsersHomeDir+"\\src\\main\\java\\DeltaxRegistration\\Delatx_registartiongForm\\screenshot"+name+"_"+formater.format(cal.getTime())+".png");
		
		try {
			org.apache.commons.io.FileUtils.copyFile(srcFile, destFile);
			// using Reporter log will create link of images which will used in reporting
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'> <img src='"+destFile.getAbsolutePath()+"'height='100' width ='100'/> </a>");
		} catch (IOException e) {
		
			log(e.getStackTrace().toString());
		}
	
		
		return destFile.toString();
		
	}
	
	public void log(String message)
	{
		log.info(message);
		Reporter.log(message);
	}
	
	public void hover(WebElement element)
	{
		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public void popupHandler()
	{
		log("collecting all open windows");
		Set<String> window = driver.getWindowHandles();
	    Iterator<String> itr = window.iterator();
	    if (itr.hasNext()) {
		  
         for (String string : window) {
			
        	 
        	 
		}
		  }
	}
	
 public void getResult(ITestResult result)
	  {
		
		if (result.getStatus()==ITestResult.SUCCESS) {
			System.out.println(result.getName());
			test.log(LogStatus.PASS, result.getName()+"test is pass");
		}else if (result.getStatus()==ITestResult.SKIP) {
			
			test.log(LogStatus.SKIP, result.getName()+"test is skipped and reason is "+result.getThrowable());
			
		}else if (result.getStatus()==ITestResult.FAILURE) {
			
			test.log(LogStatus.ERROR, result.getName()+"test is failed and reason is "+result.getThrowable());
			test.log(LogStatus.FAIL, test.addScreencast(takeScreenshot("")));
		}
		
	
			
		}
		
		@AfterMethod
		public void afterMethod(ITestResult result)
		{
			
			getResult(result);
			log("getResult method called");
			
		}
		
		@BeforeMethod
		public void beforeMethod(ITestResult result)
		{
			
			test = extent.startTest(result.getName());
			test.log(LogStatus.INFO, result.getName()+"started ");
			log("test object created for"+result.getName());
		}
		@AfterClass()
		public void endTest()
		{
			closeBrowser();
		}
	
  public void closeBrowser()
	  {
		driver.quit();
		log.info("browser closed");
		extent.endTest(test);
		extent.flush();
	  }
	
  public void Scroll(WebElement element )
	{
		
		JavascriptExecutor scroll = (JavascriptExecutor)driver;
		scroll.executeScript("arguments[0].scrollInToView();", element);
	}
	
	

	
	
	
	
	
	
	
	
	

	
	
}
