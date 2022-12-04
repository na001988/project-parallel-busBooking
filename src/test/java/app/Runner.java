package app;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Runner {
	
    WebDriver driver_1;
    WebDriver driver_2;
    String url = "https://www.agl.com.au/";

    
  @BeforeClass(groups="start")
  public void run1() throws InterruptedException{
	  try {
	  System.out.println("@@@@ Set-up browser <Firefox> for Test");
	  WebDriverManager.firefoxdriver().setup();
	  driver_1 = new FirefoxDriver();
	  driver_1.manage().getCookies().clear();
	  }catch(Exception e) {
			System.out.println("On-Run1 > Error: "+e);
		}
	  
	  try {
	  System.out.println("Set-up browser <Edge> for Test");
	  WebDriverManager.edgedriver().setup();
	  driver_2 = new EdgeDriver();
	  driver_2.manage().getCookies().clear();
	  }catch(Exception e) {
			System.out.println("On-run2 > Error: "+e);
		}
  }
  
  @AfterClass(groups="end")
  public void close() throws InterruptedException{
	  try {
		  if(driver_1 != null) driver_1.quit(); System.out.println("Close driver 1");
		  if(driver_2 != null) driver_2.quit(); System.out.println("Close driver 2");
	  }catch(Exception e) {
			System.out.println("On-Close > Error: "+e);
		}
  }
  
  
  @Test(groups="Edge")
  public void launch_Edge() throws InterruptedException {
	  try {
	  System.out.println("Web Browser Edge started...." + Thread.currentThread().getId());
	  driver_2.get(url);
	  Thread.sleep(2500);
	  }catch(Exception e) {
		  System.out.println("Warning...... launch_Edge: "+e.getMessage());
	  }
	  
  }
  
  @Test(groups="Edge", dependsOnMethods="launch_Edge")
  public void launch_Perform_App1() {
	  System.out.println("Reading elements on browser !!!!! > " + Thread.currentThread().getId());
  }
  
  

  @Test(groups="Firefox")
  public void launch_Firefox() throws InterruptedException {
	  try {
	  System.out.println("Web Browser Firefox started...." + Thread.currentThread().getId());
	  driver_1.get(url);
	  Thread.sleep(2000);
	  }catch(Exception e) {
		  System.out.println("Warning...... launch_Firefox: "+e.getMessage());
	  }
	  
  }
  
  @Test(groups="Firefox", dependsOnMethods="launch_Firefox")
  public void launch_Perform_App2() {
	  System.out.println("Reading elements on browser !!!!! > " + Thread.currentThread().getId());
  }
  

}
