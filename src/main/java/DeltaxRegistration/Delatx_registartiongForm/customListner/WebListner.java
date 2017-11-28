package DeltaxRegistration.Delatx_registartiongForm.customListner;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

public class WebListner    implements WebDriverEventListener{
	
	public final static Logger log = Logger.getLogger(WebListner.class.getName());

	public void afterAlertAccept(WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver dir, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement arg0, WebDriver dir) {
		log("clicked on element:-"+arg0);
		
	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver dir) {
		log("element found:-"+arg1);
		
	}

	public void afterNavigateBack(WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String url, WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String arg0, WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver dir, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement element, WebDriver dir) {
		log("before clicked on element:-"+element.toString());
		
	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver dir) {
		
		log("before found by"+arg1.toString());
	}

	public void beforeNavigateBack(WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String arg0, WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String arg0, WebDriver dir) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable arg0, WebDriver dir) {
		log("Exception occures:-"+arg0);
		
	}
	
	public void log(String message)
	{
		log.info(message);
		Reporter.log(message);
		
		
	}
	
	

}
