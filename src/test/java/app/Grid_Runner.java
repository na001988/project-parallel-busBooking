package app;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Grid_Runner {
	
	WebDriver driver_1;
    WebDriver driver_2;
    String browser_c ="chrome";
    String browser_f ="firefox";
    String path_browser_f ="C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    String client = "http://192.168.0.4:4444/wd/hub";
    
    String url = "https://www.google.com.au/";

    
  @BeforeClass(groups="start")
 
  public void run1() throws InterruptedException{
	  
	  try {
	  System.out.println("@@@@ Set-up browser <"+browser_c+"> for automation");
	  
	  	ChromeOptions c = new ChromeOptions();
		c.setCapability("browserName", browser_c);
		c.setCapability("Platform", "WIN10");
		c.setHeadless(true);
	  
	    URL uri = new URL(client);
		driver_1 = new RemoteWebDriver(uri,c);
	  
	  
	  }catch(Exception e) {
			System.out.println("Object-Run1 > Error: "+e);
		}
	  
	  
	  
	  try {
	  System.out.println("@@@@ Set-up browser <"+browser_f+"> for automation");
	  
	  FirefoxOptions f = new FirefoxOptions();
		f.setCapability("browserName", browser_f);
		f.setCapability("Platform", "WIN10");
		f.setBinary(path_browser_f);
		f.setHeadless(true);
	  
		URL uri = new URL(client);
		driver_2 = new RemoteWebDriver(uri,f);
	  
		
	  }catch(Exception e) {
			System.out.println("Object-run2 > Error: "+e);
		}
	  
  }
  
  @AfterClass(groups="end")
  public void close() throws InterruptedException{
	  try {
		  if(driver_1 != null) driver_1.quit(); System.out.println("Close driver "+driver_1.toString());
		  if(driver_2 != null) driver_2.quit(); System.out.println("Close driver "+driver_2.toString());
	  }catch(Exception e) {
			System.out.println("On-Close > Error: "+e);
		}
  }
  
  
  @Test(groups="chrome")
  public void launch_chrome() throws InterruptedException {
	  try {
	  System.out.println("Web Browser "+browser_c+ " started...." + Thread.currentThread().getId());
	  driver_2.get(url);
	  Thread.sleep(1000);
	  System.out.println(driver_2.getTitle());
	  }catch(Exception e) {
		  System.out.println("Warning...... while launching: "+browser_c+" | "+e.getMessage());
	  }
	  
  }
  
  @Test(groups="firefox")
  public void launch_Firefox() throws InterruptedException {
	  try {
		  System.out.println("Web Browser "+browser_f+ " started...." + Thread.currentThread().getId());
	  driver_1.get(url);
	  Thread.sleep(1500);
	  System.out.println(driver_1.getTitle());
	  }catch(Exception e) {
		  System.out.println("Warning...... while launching: "+browser_f+" | "+e.getMessage());
	  }
	  
  }

  
}
