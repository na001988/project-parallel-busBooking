package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import app.Constants;
import app.Setup;
import app.Setup.LocatorType;
import app.Setup.WebDriverAction;

public class Tickets{

	protected WebDriver driver;
	private Setup s; 

	
	protected WebElement label;
	Constants co = new Constants(); 
	
	public Tickets(WebDriver driver) {
		this.driver=driver;
	}
	
    public void run_page_2() throws InterruptedException {
    	
    	s = new Setup(driver);
   		s.find_do(co.btn_confirm,"", WebDriverAction.CLICK, LocatorType.XPATH);
   		s.find_do(co.btn_go_payment,"", WebDriverAction.CLICK, LocatorType.XPATH);

   		Thread.sleep(2000);
    }
	
}
