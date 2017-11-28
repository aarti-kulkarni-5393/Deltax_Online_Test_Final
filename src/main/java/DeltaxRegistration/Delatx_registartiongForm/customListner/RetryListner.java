package DeltaxRegistration.Delatx_registartiongForm.customListner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;
import org.testng.internal.annotations.TestAnnotation;

public class RetryListner implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		
		if (retry==null) {
			
			annotation.setRetryAnalyzer(Retry.class);
			
		}
	}
	
	

}
