package arddialling;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class ARD {

	public static void main(String[] args) throws Exception
	{
		//details of AVD and calc app
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setCapability(CapabilityType.BROWSER_NAME,"");
				dc.setCapability("deviceName", "5da184c3");
				dc.setCapability("platformName","android");
		        dc.setCapability("platformVersion","5.0.2");
		        dc.setCapability("appPackage","com.android.contacts");
		        dc.setCapability("appActivity","com.android.contacts.activities.WtDialerActivity");
		        //start appium server
		        Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		        URL u=new URL("http://0.0.0.0:4723/wd/hub");
		        // create driver object and launch app
		        
		       AndroidDriver driver;
		       while(2>1)
		       {
		    	   try
		    	   {
		    		   driver=new AndroidDriver(u,dc);
		    		   break;
		    	   }
		    	   catch(Exception e)
		    	   {
		    	   }
		       }
		        
		        
		        WebDriverWait w=new WebDriverWait(driver,20);
		        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.ImageButton']")));
		        String x1=driver.getOrientation().name();
		        if(x1.equalsIgnoreCase("potrait"));
		        {
		        	driver.rotate(ScreenOrientation.LANDSCAPE);
		        	Thread.sleep(5000);
		        	driver.lockDevice();
		        	Thread.sleep(5000);
		        	 if(driver.isDeviceLocked())
		        	 {
		        		System.out.println("Locked");
		        		driver.unlockDevice();
		        	 }
		        	Thread.sleep(8000);
		        	//close app
		        	driver.closeApp();
		        
		        	//stop appium server
		        	Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		        	Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		        	
		        }


	}

}
