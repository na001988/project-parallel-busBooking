package app;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class Runner {
	

  @Test(groups="Chrome")
  public void launch_Chrome() {
	  System.out.println("Web Browser Chrome started...." + Thread.currentThread().getId());
  }
  
  @Test(groups="Chrome", dependsOnMethods="launch_Chrome")
  public void launch_Perform_App1() {
	  System.out.println("Reading elements on browser !!!!! > " + Thread.currentThread().getId());
  }
  

  @Test(groups="Firefox")
  public void launch_Firefox() {
	  System.out.println("Web Browser Firefox started...." + Thread.currentThread().getId());
  }
  
  @Test(groups="Firefox", dependsOnMethods="launch_Firefox")
  public void launch_Perform_App2() {
	  System.out.println("Reading elements on browser !!!!! > " + Thread.currentThread().getId());
  }
  

}
