package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import app.Constants;
import app.Setup;
import app.Setup.LocatorType;
import app.Setup.WebDriverAction;

public class Dates{

	protected WebDriver driver;
	private Setup s; 

	
	protected WebElement label;
	Constants co = new Constants(); 
	
	public Dates(WebDriver driver) {
		this.driver=driver;
	}
	
    public void run_page_1() throws InterruptedException {
    	
    	s = new Setup(driver);
    	
    	//booking process: booking > manage > track
    	//page-1: dates
    	//page-2: tickets
    	//page-3: travellers (out of scope)
    	//page-4: payment (out of scope)
    		
    		s.find_do(co.route_id,"", WebDriverAction.CLICK, LocatorType.ID);
    		s.find_do(co.depart_id,co.depart,WebDriverAction.SELECT, LocatorType.ID);
    		s.find_do(co.arrive_id,co.arrive,WebDriverAction.SELECT, LocatorType.ID);
    		s.find_do(co.trip_id,"",WebDriverAction.PERFORM, LocatorType.ID);
    		s.find_do(co.date_id,"",WebDriverAction.CLICK, LocatorType.ID);
    		s.find_do(co.date_id,co.date_plan,WebDriverAction.SETTEXT, LocatorType.ID);
    		s.find_do("pan_ReturningDate","",WebDriverAction.CLICK, LocatorType.ID);
    		s.find_do(co.child_text,"", WebDriverAction.CLICK, LocatorType.XPATH);
    		s.find_do(co.more_adult,"", WebDriverAction.CLICK, LocatorType.XPATH);
    		s.find_do(co.more_child,"", WebDriverAction.CLICK, LocatorType.XPATH);
    		s.find_do(co.more_student,"", WebDriverAction.CLICK, LocatorType.XPATH);
    		s.find_do(co.adult_pos,"", WebDriverAction.CLICK, LocatorType.XPATH);
    		s.find_do(co.child_pos,"", WebDriverAction.CLICK, LocatorType.XPATH);
    		s.find_do(co.student_pos,"", WebDriverAction.CLICK, LocatorType.XPATH);  
    		s.find_do(co.btn_do_booking,"", WebDriverAction.CLICK, LocatorType.XPATH);
    		
    }
}
