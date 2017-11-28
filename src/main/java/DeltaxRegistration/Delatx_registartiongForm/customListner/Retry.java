package DeltaxRegistration.Delatx_registartiongForm.customListner;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Retry implements IRetryAnalyzer {
	
	public static final Logger log = Logger.getLogger(Retry.class);
	
	private int retryCount =0;
	private int maxRetryCount =3;
	

	public boolean retry(ITestResult result) {
		if (retryCount< maxRetryCount) {
			
			log("Retrying test"+result.getName()+"   with status  "+getResultStatus(result.getStatus())+"   for the    "+(retryCount+1));
			retryCount++;
			return true;
			
		}

		 return false;
	}
	
	public String getResultStatus(int status)
	{
		String resultName;
		
		if (status==1) {
			resultName= "Success";
			
		}else if (status==2) {
			resultName= "Failure";
			
		}else {
			resultName= "Skipped";
			
		}
		
		
		
		return resultName;
		
	}
	public void log(String message)
	{
		log.info(message);
		Reporter.log(message);
		
		
	}

}
