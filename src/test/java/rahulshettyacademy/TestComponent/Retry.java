package rahulshettyacademy.TestComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


// This class is done so we rerun the failures number of times to make sure that they actually failed
public class Retry implements IRetryAnalyzer {

	
	int count=0;
	int maxTry=1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxTry)
		{
			count++;
			return true;
		}
		return false;
	}
	

}
