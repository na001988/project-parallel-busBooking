package app;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


public class Setup {

	protected WebDriver driver;
	protected WebElement label;
	public LocatorType locator;
	Constants co = new Constants();  

	public Setup(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver run(String val, String brw) throws InterruptedException {
		if (brw.equals(co.browser_c)) {
			try {
				System.out.println("@@@@ Set-up browser <" + brw + "> for automation");
				ChromeOptions c = new ChromeOptions();
				c.setCapability(CapabilityType.BROWSER_NAME, brw);
				c.setHeadless(co.is_headless);
				URL uri = new URL(co.hub);
				return driver = new RemoteWebDriver(uri, c);
			} catch (Exception e) {
				System.out.println("Object-Run1 > Error: " + e);
			}
		}

		if (brw.equals(co.browser_f)) {
			try {
				System.out.println("@@@@ Set-up browser <" + brw + "> for automation");
				FirefoxOptions f = new FirefoxOptions();
				f.setCapability(CapabilityType.BROWSER_NAME, brw);
				f.setBinary(co.path_browser_f);
				f.setHeadless(co.is_headless);
				URL uri = new URL(co.hub);
				return driver = new RemoteWebDriver(uri, f);
			} catch (Exception e) {
				System.out.println("Object-run2 > Error: " + e);
			}
		}
		return driver;

	}

	public WebElement locateWebElement(WebDriver obj, LocatorType l, String info) throws InterruptedException {

		try {
			
			Thread.sleep(co.delay());
			
			WebElement dynamicElement;
			switch (l) {
			case XPATH -> dynamicElement = obj.findElement(By.xpath(info));
			case ID -> dynamicElement = obj.findElement(By.id(info)); 
			case LINK_TEXT -> dynamicElement = obj.findElement(By.linkText(info));
			case CSS_SELECTOR -> dynamicElement = obj.findElement(By.cssSelector(info));
			case PARTIAL_LINK_TEXT -> dynamicElement = obj.findElement(By.partialLinkText(info));
			default -> throw new TypeNotPresentException("Warning ..... "+locator.getClass().getName(), null);
			
			}

			Thread.sleep(co.delay());

			return dynamicElement;

		} catch (StaleElementReferenceException | ElementNotInteractableException | NoSuchElementException | UnhandledAlertException ex) {
			System.out.println("Error on locateWebElement() > " + ex.getMessage());
			return locateWebElement(driver, l, info);
		}
	}

	public void PerformAction(WebElement we, WebDriverAction act, String data) {
		String var_value = "";
		Actions at = new Actions(driver);

		try {
			switch (act) {
			case CLICK -> {
				we.click();
			}
			case CLEAR -> {
				we.click();
				we.clear();
			}
			case GETTEXT -> {
				var_value = we.getText();
				if(var_value.length()==0) {
					var_value = we.getAttribute("alt");
					if(var_value.length()==0) {
						var_value = we.getAttribute("name");
					}
				}
			}
			case SETTEXT -> {
				we.sendKeys(data);
			}
			case SELECT -> {
				Select sl = new Select(we);
		        sl.selectByVisibleText(data);
			}
			case PERFORM -> {
				at.moveToElement(we).click().perform();
			}			
			default -> {
				Thread.sleep(2500);
			}
			}

		} catch (Exception e) {
			System.out.println("Warning on PerformAction(x,y,z) > " + e.getMessage());
		}
	}

	public enum LocatorType {
		ID, NAME, CLASS_NAME, XPATH, TAG_NAME, CSS_SELECTOR, LINK_TEXT, PARTIAL_LINK_TEXT,
	}

	public enum WebDriverAction {
		CLEAR, CLICK, INPUT, SELECT, GETTEXT, SETTEXT, PERFORM 
	}
	
	
	public void find_do(String x, String y, WebDriverAction z, LocatorType l) throws InterruptedException {
		PerformAction(findByLinkText(x, l), z, y);
	}

	
	private WebElement findByLinkText(String x, LocatorType l) throws InterruptedException {
		return label = locateWebElement(driver, l, x);
	}

}
