package app;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Dates;
import pages.Tickets;

public class Grid_Runner {
	
	WebDriver driver_1;
    WebDriver driver_2;
    Constants co = new Constants();
    
    
  @BeforeClass(groups="start")
   public void run1() throws InterruptedException{
	  
	  Setup ob1 = new Setup(driver_1);
	  Setup ob2 = new Setup(driver_2);
	  driver_1 = ob1.run(co.base_uri,co.browser_f);
	  driver_2 = ob2.run(co.base_uri,co.browser_c);
  }
  
  @AfterClass(groups="end")
  public void close() throws InterruptedException{
	  try {
		  if(driver_1 != null) driver_1.quit(); System.out.println("Close driver "+driver_1.toString());
		  
	  }catch(Exception e) {
			System.out.println("On-Close-1 > Error: "+e);
		}
	  
	  try {
		  
		  if(driver_2 != null) driver_2.quit(); System.out.println("Close driver "+driver_2.toString());
	  }catch(Exception e) {
			System.out.println("On-Close-2 > Error: "+e);
		}
  }
  
  
  @Test(groups="chrome")
  public void launch_chrome() throws InterruptedException {
	  //passing WebDriver instance to call and execute methods
	  Dates d = new Dates(driver_2);
	  Tickets t = new Tickets(driver_2);
	  
	  try {
	  System.out.println("Web Browser "+driver_2.toString()+ " started...." + Thread.currentThread().getId());
	  driver_2.get(co.base_uri);
	  Thread.sleep(co.delay());
	  d.run_page_1();
	  t.run_page_2();
	  System.out.println(driver_2.getTitle());
	  }catch(Exception e) {
		  System.out.println("Warning...... while launching: "+driver_2.toString()+" | "+e.getMessage());
	  }
	  
  }
  
  @Test(groups="firefox")
  public void launch_Firefox() throws InterruptedException {
	//passing WebDriver instance to call and execute methods
	  Dates d = new Dates(driver_1);
	  Tickets t = new Tickets(driver_1);
	  
	  try {
		  System.out.println("Web Browser "+driver_1.toString()+ " started...." + Thread.currentThread().getId());
	  driver_1.get(co.base_uri);
	  Thread.sleep(co.delay()+500);
	  d.run_page_1();
	  t.run_page_2();
	  System.out.println(driver_1.getTitle());
	  }catch(Exception e) {
		  System.out.println("Warning...... while launching: "+driver_1.toString()+" | "+e.getMessage());
	  }
	  
  }

  
}
