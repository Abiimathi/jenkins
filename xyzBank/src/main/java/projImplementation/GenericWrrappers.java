package projImplementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.Select;

import utils.Report;

public class GenericWrrappers extends Report implements Wrappers {
	
	public RemoteWebDriver driver ;

	public void invokeApp(String browser, String url) {
		
		
		try {
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("InternetExplorer")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverserver.exe");
				driver = new InternetExplorerDriver();
			}
			
			driver.manage().window().maximize();
			driver.get(url);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//System.out.println("The browser "+browser+ " is launched with the given url " +url+ "successfully");
			reportStep("The browser "+browser+ " is launched with the given url " +url+ " successfully", "pass");
			
		} catch (UnreachableBrowserException e) {
			
			//System.err.println("The "+ browser+" was unreachable");
			reportStep("The "+ browser+" was unreachable", "fail");
		}catch (SessionNotCreatedException e) {
			
			//System.err.println("The browser " +browser+" is not launched due to Session not created exception");
			reportStep("The browser " +browser+" is not launched due to Session not created exception", "fail");
			
		}catch (InvalidArgumentException e) {
			
			//System.err.println("The browser "+browser+" is not launched as the url does not contain http/https");
			reportStep("The browser "+browser+" is not launched as the url does not contain http/https", "fail");
			
		} catch ( WebDriverException e) {
			
			//System.err.println("There was a problem communicating with the"+ browser+ " due to unknown error");
			reportStep("There was a problem communicating with the"+ browser+ " due to unknown error", "fail");
		}
		
		
	}

	public void clearById(String idValue) {
		try {
			driver.findElementById(idValue).clear();
			reportStep("The String in element with id "+idValue+" is cleared", "pass");
		}catch (NoSuchElementException e) {
			//System.err.println("The element with id "+idValue+" is not found");
			reportStep("The element with id "+idValue+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with id "+idValue+" is not visible");
			reportStep("The element with id "+idValue+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with id "+idValue+" is not stable");
			reportStep("The element with id "+idValue+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+idValue+" is not interactable");
			reportStep("The element with id "+idValue+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with id "+idValue+" is not found in DOM");
			reportStep("The element with id "+idValue+" is not found in DOM", "fail");
		} catch ( WebDriverException e) {
			
			//System.err.println("The String in element with id "+idValue+" is not cleared due to unknown error");
			reportStep("The element with id "+idValue+" is not cleared due to unknown error", "fail");
		}
		
	}
	
	public void enterById(String idValue, String data) {
		
		try {
			driver.findElementById(idValue).sendKeys(data);
			//System.out.println("The element is found using the id "+idValue+" and the value "+data+" is entered");
			reportStep("The element is found using the id "+idValue+" and the value "+data+" is entered", "pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with id "+idValue+" is not found");
			reportStep("The element with id "+idValue+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with id "+idValue+" is not visible");
			reportStep("The element with id "+idValue+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with id "+idValue+" is not stable");
			reportStep("The element with id "+idValue+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+idValue+" is not interactable");
			reportStep("The element with id "+idValue+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with id "+idValue+" is not found in DOM");
			reportStep("The element with id "+idValue+" is not found in DOM", "fail");
		} catch ( WebDriverException e) {
			//System.err.println("The element with id "+idValue+" is not entered with "+data+ "due to unknown error");
			reportStep("The element with id "+idValue+" is not entered with "+data+ "due to unknown error", "fail");
		}
	}

	public void enterById(String idValue, Keys key, String keyName) {
		try {
			driver.findElementById(idValue).sendKeys(key);
			//System.out.println("The element is found using the id "+idValue+" and the "+key+" key is pressed");
			reportStep("The element is found using the id "+idValue+" and the "+keyName+ " key is pressed", "pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with id "+idValue+" is not found");
			reportStep("The element with id "+idValue+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with id "+idValue+" is not visible");
			reportStep("The element with id "+idValue+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with id "+idValue+" is not stable");
			reportStep("The element with id "+idValue+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+idValue+" is not intractable");
			reportStep("The element with id "+idValue+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with id "+idValue+" is not found in DOM");
			reportStep("The element with id "+idValue+" is not found in DOM", "fail");
		} catch ( WebDriverException e) {	
			//System.err.println("The element with id "+idValue+" is not found and the "+key+" key is not pressed");
			reportStep("The element with id "+idValue+" is not found and the "+key+" key is not pressed", "fail");
		}

	}
	
	public void enterByXpath(String xpath, Keys key, String keyName) {
		try {
			driver.findElementByXPath(xpath).sendKeys(key);
			//System.out.println("The element is found using the xpath "+idValue+" and the "+key+" key is pressed");
			reportStep("The element is found using the xpath "+xpath+" and the "+keyName+ " key is pressed", "pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with xpath "+idValue+" is not found");
			reportStep("The element with xpath "+xpath+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with xpath "+idValue+" is not visible");
			reportStep("The element with xpath "+xpath+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with xpath "+idValue+" is not stable");
			reportStep("The element with xpath "+xpath+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with xpath "+idValue+" is not intractable");
			reportStep("The element with xpath "+xpath+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with xpath "+idValue+" is not found in DOM");
			reportStep("The element with xpath "+xpath+" is not found in DOM", "fail");
		} catch ( WebDriverException e) {	
			//System.err.println("The element with xpath "+idValue+" is not found and the "+key+" key is not pressed");
			reportStep("The element with xpath "+xpath+" is not found and the "+key+" key is not pressed", "fail");
		}
		
	}
	
	public void enterByName(String nameValue, String data) {
		
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			//System.out.println("The element is found using the  name "+nameValue+" and the value "+data+" is entered");
			reportStep("The element is found using the  name "+nameValue+" and the value "+data+" is entered", "pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with id "+nameValue+" is not found");
			reportStep("The element with id "+nameValue+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with id "+nameValue+" is not visible");
			reportStep("The element with id "+nameValue+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with id "+nameValue+" is not stable");
			reportStep("The element with id "+nameValue+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+nameValue+" is not interactable");
			reportStep("The element with id "+nameValue+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with id "+nameValue+" is not found in DOM");
			reportStep("The element with id "+nameValue+" is not found in DOM", "fail");
		} catch ( WebDriverException e) {
			//System.err.println("The element with id "+nameValue+" is not entered with "+data+ "due to unknown error");
			reportStep("The element with id "+nameValue+" is not entered with "+data+ "due to unknown error", "fail");
		}

	}

	public void enterByXpath(String xpathValue, String data) {
		
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			//System.out.println("The element is found using xpath "+xpathValue+" and the value "+data+" is entered");
			reportStep("The element is found using xpath "+xpathValue+" and the value "+data+" is entered", "pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with id "+xpathValue+" is not found");
			reportStep("The element with id "+xpathValue+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with id "+xpathValue+" is not visible");
			reportStep("The element with id "+xpathValue+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with id "+xpathValue+" is not stable");
			reportStep("The element with id "+xpathValue+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+xpathValue+" is not interactable");
			reportStep("The element with id "+xpathValue+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with id "+xpathValue+" is not found in DOM");
			reportStep("The element with id "+xpathValue+" is not found in DOM", "fail");
		} catch ( WebDriverException e) {
			//System.err.println("The element with id "+xpathValue+" is not entered with "+data+ "due to unknown error");
			reportStep("The element with id "+xpathValue+" is not entered with "+data+ "due to unknown error", "fail");
		}
	}

	public void verifyTitle(String title) {
		
		try {
			String actualTitle = driver.getTitle();
			if(title.equals(actualTitle)) {
				//System.out.println("The page title "+actualTitle+" is matched with the expected title"+title);
				reportStep("The page title "+actualTitle+" is matched with the expected title"+title, "pass");
			}
			else {
				//System.err.println("The page title "+actualTitle+" is not matched with the expected title"+title);
				reportStep("The page title "+actualTitle+" is not matched with the expected title"+title, "fail");
			}
		} catch (WebDriverException e) {
			//System.err.println("The page tile "+title+" is not verified due to unknown error");
			reportStep("The page tile "+title+" is not verified due to unknown error", "fail");
		}
	}
	
	public void verifyTextById(String id, String text) {
		
		try {
			String actualtext = driver.findElementById(id).getText();
			if(text.equals(actualtext)) {
				//System.out.println("The given text "+text+" is matched with the actual text "+actualtext+" in xpath "+id);
				reportStep("The given text '"+text+"' is matched with the actual text '"+actualtext+"' in Id "+id, "pass");
			}
			else {
				//System.out.println("The given text "+text+" is not matched with the actual text "+actualtext+" in xpath "+id);
				reportStep("The given text '"+text+"' is not matched with the actual text '"+actualtext+"' in Id "+id, "pass");
			}
		}  catch (NoSuchElementException e) {
			//System.err.println("The element with id "+id+" is not found");
			reportStep("The element with id "+id+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with id "+id+" is not visible");
			reportStep("The element with id "+id+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with id "+id+" is not stable");
			reportStep("The element with id "+id+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+id+" is not interactable");
			reportStep("The element with id "+id+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with id "+id+" is not found in DOM");
			reportStep("The element with id "+id+" is not found in DOM", "fail");
		} catch ( WebDriverException e) {
			//System.err.println("The text "+text+" is not verified due to unknown error");
			reportStep("The text "+text+" is not verified due to unknown error", "fail");
		}
	}

	public void verifyTextByXpath(String xpath, String text) {
		try {
				String actualtext = driver.findElementByXPath(xpath).getText();
				if(text.equals(actualtext)) {
					//System.out.println("The given text "+text+" is matched with the actual text "+actualtext+" in xpath "+xpath);
					reportStep("The given text '"+text+"' is matched with the actual text '"+actualtext+"' in xpath "+xpath, "pass");
				}
				else {
					//System.err.println("The given text '"+text+"' is not matched with the actual text '"+actualtext+"' in xpath "+xpath);
					reportStep("The given text '"+text+"' is not matched with the actual text '"+actualtext+"' in xpath "+xpath, "fail");
				}
			}catch (NoSuchElementException e) {
				//System.err.println("The element with xpath "+xpath+" is not found");
				reportStep("The element with xpath "+xpath+" is not found", "fail");
			} catch (ElementNotVisibleException e) {
				//System.err.println("The element with xpath "+xpath+" is not visible");
				reportStep("The element with xpath "+xpath+" is not visible", "fail");
			} catch (StaleElementReferenceException e) {
				//System.err.println("The element with xpath "+xpath+" is not stable");
				reportStep("The element with xpath "+xpath+" is not stable", "fail");
			} catch (ElementNotInteractableException e) {
				//System.err.println("The element with xpath "+xpath+" is not interactable");
				reportStep("The element with xpath "+xpath+" is not interactable", "fail");
			} catch (NotFoundException e) {
				//System.err.println("The element with xpath "+xpath+" is not found in DOM");
				reportStep("The element with xpath "+xpath+" is not found in DOM", "fail");
			} catch ( WebDriverException e) {
				//System.err.println("The text "+text+" is not verified due to unknown error");
				reportStep("The text "+text+" is not verified due to unknown error", "fail");
		}
		
	}

	public void verifyTextContainsById(String id, String text) {
		try {
			String actualtext = driver.findElementById(id).getText();
			if(actualtext.contains(text)) {
				//System.out.println("The given text "+text+" contains in the actual text "+actualtext);
				reportStep("The given text '"+text+"' contains in the actual text '"+actualtext+"'", "pass");
			}
			else {
				//System.err.println("The given text "+text+" does not contains in the actual text "+actualtext);
				reportStep("The given text '"+text+"' does not contains in the actual text '"+actualtext+"'", "pass");
			}
		} catch (NoSuchElementException e) {
			//System.err.println("The element with id "+id+" is not found");
			reportStep("The element with id "+id+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with id "+id+" is not visible");
			reportStep("The element with id "+id+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with id "+id+" is not stable");
			reportStep("The element with id "+id+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+id+" is not interactable");
			reportStep("The element with id "+id+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with id "+id+" is not found in DOM");
			reportStep("The element with id "+id+" is not found in DOM", "fail");
		} catch (WebDriverException e) {
			//System.err.println("The text "+text+" is not verified due to unknown error");
			reportStep("The text "+text+" is not verified due to unknown error", "fail");
		}

	}	
	
	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String actualtext = driver.findElementByXPath(xpath).getText();
			if(text.contains(actualtext)) {
				//System.out.println("The given text "+text+" contains the actual text "+actualtext);
				reportStep("The given text '"+text+"' contains in the actual text '"+actualtext+"'", "pass");
			}
			else {
				//System.err.println("The given text "+text+"  does not contains the actual text "+actualtext);
				reportStep("The given text '"+text+"' does not contains in the actual text '"+actualtext+"'", "pass");
			}
		}catch (NoSuchElementException e) {
			//System.err.println("The element with xpath "+xpath+" is not found");
			reportStep("The element with xpath "+xpath+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with xpath "+xpath+" is not visible");
			reportStep("The element with xpath "+xpath+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with xpath "+xpath+" is not stable");
			reportStep("The element with xpath "+xpath+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with xpath "+xpath+" is not interactable");
			reportStep("The element with xpath "+xpath+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with xpath "+xpath+" is not found in DOM");
			reportStep("The element with xpath "+xpath+" is not found in DOM", "fail");
		} catch ( WebDriverException e) {
			//System.err.println("The text "+text+" is not verified due to unknown error");
			reportStep("The text "+text+" is not verified due to unknown error", "fail");
		}
	}
	
	public void clickById(String id) {
		
		try {
			driver.findElementById(id).click();
			//System.out.println("The element is found by id "+id+" and it is clicked");
			reportStep("The element is found by id "+id+" and it is clicked", "pass");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("The element in the id "+id+" is hidden so it cannot be clicked" );
			reportStep("The element in the id "+id+" is hidden so it cannot be clicked", "fail");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with id "+id+" is not found");
			reportStep("The element with id "+id+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with id "+id+" is not visible");
			reportStep("The element with id "+id+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with id "+id+" is not stable");
			reportStep("The element with id "+id+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+id+" is not interactable");
			reportStep("The element with id "+id+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with id "+id+" is not found in DOM");
			reportStep("The element with id "+id+" is not found in DOM", "fail");
		}
	}

	public void clickByClassName(String classVal) {

		try {
			driver.findElementByClassName(classVal).click();
			//System.out.println("The element is found by className "+classVal+" and it is clicked");
			reportStep("The element is found by className "+classVal+" and it is clicked", "pass");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("The element in the className "+classVal+" is hidden so it cannot be clicked" );
			reportStep("The element in the className "+classVal+" is hidden so it cannot be clicked", "fail");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with className "+classVal+" is not found");
			reportStep("The element with className "+classVal+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with className "+classVal+" is not visible");
			reportStep("The element with className "+classVal+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with className "+classVal+" is not stable");
			reportStep("The element with className "+classVal+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with className "+classVal+" is not interactable");
			reportStep("The element with className "+classVal+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with className "+classVal+" is not found in DOM");
			reportStep("The element with className "+classVal+" is not found in DOM", "fail");
		}
	}

	public void clickByName(String name) {
		
		try {
			driver.findElementByName(name).click();
			//System.out.println("The element is found by Name "+name+" and it is clicked");
			reportStep("The element is found by Name "+name+" and it is clicked", "pass");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("The element in the name "+name+" is hidden so it cannot be clicked" );
			reportStep("The element in the name "+name+" is hidden so it cannot be clicked", "fail");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with name "+name+" is not found");
			reportStep("The element with name "+name+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with name "+name+" is not visible");
			reportStep("The element with name "+name+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with name "+name+" is not stable");
			reportStep("The element with name "+name+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with name "+name+" is not interactable");
			reportStep("The element with name "+name+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with name "+name+" is not found in DOM");
			reportStep("The element with name "+name+" is not found in DOM", "fail");
		}
		
	}

	public void clickByLink(String name) {
		
		try {
			driver.findElementByLinkText(name).click();
			//System.out.println("The element is found by link "+name+" and it is clicked");
			reportStep("The element is found by link "+name+" and it is clicked", "pass");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("The element in the name "+name+" is hidden so it cannot be clicked" );
			reportStep("The element in "+name+" is hidden so it cannot be clicked", "fail");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with name "+name+" is not found");
			reportStep("The element in "+name+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with name "+name+" is not visible");
			reportStep("The element in "+name+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with name "+name+" is not stable");
			reportStep("The element in "+name+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with name "+name+" is not interactable");
			reportStep("The element in "+name+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with name "+name+" is not found in DOM");
			reportStep("The element in "+name+" is not found in DOM", "fail");
		}
		
	}

	public void clickByLinkNoSnap(String name) {
		
		try {
			driver.findElementByLinkText(name).click();
			//System.out.println("The element is found by link "+name+" and it is clicked");
			reportStep("The element is found by link "+name+" and it is clicked", "pass",false);
		} catch (ElementClickInterceptedException e) {
			//System.err.println("The element in the name "+name+" is hidden so it cannot be clicked" );
			reportStep("The element in "+name+" is hidden so it cannot be clicked", "fail",false);
		} catch (NoSuchElementException e) {
			//System.err.println("The element with name "+name+" is not found");
			reportStep("The element in "+name+" is not found", "fail",false);
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with name "+name+" is not visible");
			reportStep("The element in "+name+" is not visible", "fail",false);
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with name "+name+" is not stable");
			reportStep("The element in "+name+" is not stable", "fail",false);
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with name "+name+" is not interactable");
			reportStep("The element in "+name+" is not interactable", "fail",false);
		} catch (NotFoundException e) {
			//System.err.println("The element with name "+name+" is not found in DOM");
			reportStep("The element in "+name+" is not found in DOM", "fail",false);
		}
	}
	
	public void clickByXpath(String xpathVal) {
		
		try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("The element with xpath "+xpathVal+" is found and clicked");
			reportStep("The element with xpath "+xpathVal+" is found and clicked", "pass");
		}   catch (ElementClickInterceptedException e) {
			//System.err.println("The element in the xpathVal "+xpathVal+" is hidden so it cannot be clicked" );
			reportStep("The element in the xpathVal "+xpathVal+" is hidden so it cannot be clicked", "fail");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with id "+xpathVal+" is not found");
			reportStep("The element with id "+xpathVal+" is not found", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with id "+xpathVal+" is not visible");
			reportStep("The element with id "+xpathVal+" is not visible", "fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with id "+xpathVal+" is not stable");
			reportStep("The element with id "+xpathVal+" is not stable", "fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+xpathVal+" is not interactable");
			reportStep("The element with id "+xpathVal+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("The element with id "+xpathVal+" is not found in DOM");
			reportStep("The element with id "+xpathVal+" is not found in DOM", "fail");
		} catch ( WebDriverException e) {
			//System.err.println("The element with id "+xpathVal+" is not clicked due to unknown error");
			reportStep("The element with id "+xpathVal+" is not clicked due to unknown error", "fail");
		}
		
	}

	public void clickByXpathNoSnap(String xpathVal) {
		
		try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("The element with xpath "+xpathVal+" is found and clicked");
			reportStep("The element with xpath "+xpathVal+" is found and clicked", "pass",false);
		}   catch (ElementClickInterceptedException e) {
			//System.err.println("The element in the xpathVal "+xpathVal+" is hidden so it cannot be clicked" );
			reportStep("The element in the xpathVal "+xpathVal+" is hidden so it cannot be clicked", "fail",false);
		} catch (NoSuchElementException e) {
			System.err.println("The element with id "+xpathVal+" is not found");
			reportStep("The element with xpath "+xpathVal+" is not found", "fail",false);
		} catch (ElementNotVisibleException e) {
			//System.err.println("The element with id "+xpathVal+" is not visible");
			reportStep("The element with xpath "+xpathVal+" is not visible", "fail",false);
		} catch (StaleElementReferenceException e) {
			//System.err.println("The element with id "+xpathVal+" is not stable");
			reportStep("The element with xpath "+xpathVal+" is not stable", "fail",false);
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+xpathVal+" is not interactable");
			reportStep("The element with xpath "+xpathVal+" is not interactable", "fail",false);
		} catch (NotFoundException e) {
			//System.err.println("The element with id "+xpathVal+" is not found in DOM");
			reportStep("The element with xpath "+xpathVal+" is not found in DOM", "fail",false);
		} catch ( WebDriverException e) {
			//System.err.println("The element with id "+xpathVal+" is not clicked due to unknown error");
			reportStep("The element with xpath "+xpathVal+" is not clicked due to unknown error", "fail",false);
		}
		
	}

	public String getTextById(String idVal) {
		String actualtxt = null;
		try {
			 actualtxt =  driver.findElementById(idVal).getText();
			//System.out.println("The text in the element with id "+idVal+" is "+actualtxt);
			reportStep("The text in the element with id "+idVal+" is "+actualtxt, "pass");
		} catch (NoSuchElementException e) {
			//System.err.println("Unable to get the text since the element with id "+idVal+" is not found");
			reportStep("Unable to get the text since the element with id "+idVal+" is not found", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("Unable to get the text since the element with id "+idVal+" is not stable");
			reportStep("Unable to get the text since the element with id "+idVal+" is not stable", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("Unable to get the text since the element with id "+idVal+" is not interactable");
			reportStep("Unable to get the text since the element with id "+idVal+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("Unable to get the text since the element with id "+idVal+" is not found in DOM");
			reportStep("Unable to get the text since the element with id "+idVal+" is not found in DOM", "fail");
		} catch ( WebDriverException e) {
			
			//System.err.println("Unable to get the text since the element with id "+idVal+" is not found due to unknown error");
			reportStep("Unable to get the text since the element with id "+idVal+" is not found due to unknown error", "fail");
		}
		return actualtxt;
	}

	public String getTextByXpath(String xpathVal) {
		String actualtxt = null;
		try {
			 actualtxt =  driver.findElementByXPath(xpathVal).getText();
			//System.out.println("The text in the element with XPath "+xpathVal+" is "+actualtxt);
			//reportStep("The text in the element with XPath "+xpathVal+" is "+actualtxt, "pass");
		}catch (NoSuchElementException e) {
			//System.err.println("Unable to get the text since the element with xpath "+xpathVal+" is not found");
			reportStep("Unable to get the text since the element with xpath "+xpathVal+" is not found", "Fail");
		} catch (StaleElementReferenceException e) {
			//System.err.println("Unable to get the text since the element with xpath "+xpathVal+" is not stable");
			reportStep("Unable to get the text since the element with xpath "+xpathVal+" is not stable", "Fail");
		} catch (ElementNotInteractableException e) {
			//System.err.println("Unable to get the text since the element with xpath "+xpathVal+" is not interactable");
			reportStep("Unable to get the text since the element with xpath "+xpathVal+" is not interactable", "fail");
		} catch (NotFoundException e) {
			//System.err.println("Unable to get the text since the element with xpath "+xpathVal+" is not found in DOM");
			reportStep("Unable to get the text since the element with xpath "+xpathVal+" is not found in DOM", "fail");
		} catch ( WebDriverException e) {
			
			//System.err.println("Unable to get the text since the element with xpath "+xpathVal+" is not found due to unknown error");
			reportStep("Unable to get the text since the element with xpath "+xpathVal+" is not found due to unknown error", "fail");
		}
		return actualtxt;
	}

	public void selectVisibileTextById(String id, String value) {
		
		try {
			WebElement wb = driver.findElementById(id);
			Select element = new Select(wb);
			element.selectByVisibleText(value);
			//System.out.println("For the id +id+ from the drop down the visible text "+value+" is selected");
			reportStep("For the id "+id+" ,from the drop down the visible text "+value+" is selected", "pass");
		} catch (ElementNotSelectableException e) {
			//System.err.println("For the id "+id+" from the drop down the visible text "+value+" is not selectable");
			reportStep("For the id "+id+" ,from the drop down the visible text "+value+" is not selectable", "fail");
		}catch (WebDriverException e) {
			//System.err.println("For the id "+id+" from the drop down the visible text "+value+" is not selectable due to unknown error");
			reportStep("For the id "+id+" ,from the drop down the visible text "+value+" is not selectable due to unknown error", "fail");
		}

	}

	public void selectIndexById(String id, int value) {

		try {
			WebElement wb = driver.findElementById(id);
			Select element = new Select(wb);
			element.selectByIndex(value);
			//System.out.println("For the id "+id+" from the drop down the index "+value+" is selected");
			reportStep("For the id "+id+" from the drop down the index "+value+" is selected", "pass");
		} catch (ElementNotSelectableException e) {
			//System.err.println("For the id "+id+" from the drop down the index "+value+" is not selectable");
			reportStep("For the id "+id+" from the drop down the index "+value+" is not selectable", "fail");
		} catch (WebDriverException e) {
			//System.err.println("For the id "+id+" from the drop down the index "+value+" is not selectable due to unknown error");
			reportStep("For the id "+id+" from the drop down the index "+value+" is not selectable due to unknown error", "fail");
		}
	}
	
	public void selectVisibileTextByXpath(String xpath, String value) {
		
		try {
			WebElement wb = driver.findElementByXPath(xpath);
			Select element = new Select(wb);
			element.selectByVisibleText(value);
			//System.out.println("For the id "+xpath+" from the drop down the visible text "+value+" is selected");
			reportStep("For the id "+xpath+" from the drop down the visible text "+value+" is selected", "pass");
		} catch (ElementNotSelectableException e) {
			//System.err.println("For the id "+xpath+" from the drop down the visible text "+value+" is not selectable");
			reportStep("For the id "+xpath+" from the drop down the visible text "+value+" is not selectable", "fail");
		}catch (WebDriverException e) {
			//System.err.println("For the id "+xpath+" from the drop down the visible text "+value+" is not selectable due to unknown error");
			reportStep("For the id "+xpath+" from the drop down the visible text "+value+" is not selectable due to unknown error", "fail");
		}
	}

	public void selectIndexByXpath(String xpath, int value) {

		try {
			WebElement wb = driver.findElementByXPath(xpath);
			Select element = new Select(wb);
			element.selectByIndex(value);
			//System.out.println("For the id "+xpath+" from the drop down the index "+value+" is selected");
			reportStep("For the id "+xpath+" from the drop down the index "+value+" is selected", "pass");
		} catch (ElementNotSelectableException e) {
			//System.err.println("For the id "+xpath+" from the drop down the index "+value+" is not selectable");
			reportStep("For the id "+xpath+" from the drop down the index "+value+" is not selectable", "fail");
		} catch (WebDriverException e) {
			//System.err.println("For the id "+xpath+" from the drop down the index "+value+" is not selectable due to unknown error");
			reportStep("For the id "+xpath+" from the drop down the index "+value+" is not selectable due to unknown error", "fail");
		}
		
	}
	
	public void selectValueByXpath(String xpath, String value) {
		try {
			WebElement wb = driver.findElementByXPath(xpath);
			Select element = new Select(wb);
			element.selectByValue(value);
			//System.out.println("For the xpath "+xpath+" from the drop down the Value "+value+" is selected");
			reportStep("For the xpath "+xpath+" from the drop down the Value "+value+" is selected", "pass");
		} catch (ElementNotSelectableException e) {
			//System.err.println("For the xpath "+xpath+" from the drop down the Value "+value+" is not selectable");
			reportStep("For the xpath "+xpath+" from the drop down the Value "+value+" is not selectable", "fail");
		} catch (WebDriverException e) {
			//System.err.println("For the xpath "+xpath+" from the drop down the Value "+value+" is not selectable due to unknown error");
			reportStep("For the xpath "+xpath+" from the drop down the Value "+value+" is not selectable due to unknown error", "fail");
		}	
	}
	
	public void selectValueById(String id, String value) {
		try {
			WebElement wb = driver.findElementById(id);
			Select element = new Select(wb);
			element.selectByValue(value);
			//System.out.println("For the id "+id+" from the drop down the Value "+value+" is selected");
			reportStep("For the id "+id+" from the drop down the Value "+value+" is selected", "pass");
		} catch (ElementNotSelectableException e) {
			//System.err.println("For the id "+id+" from the drop down the Value "+value+" is not selectable");
			reportStep("For the id "+id+" from the drop down the Value "+value+" is not selectable", "fail");
		} catch (WebDriverException e) {
			//System.err.println("For the id "+id+" from the drop down the Value "+value+" is not selectable due to unknown error");
			reportStep("For the id "+id+" from the drop down the Value "+value+" is not selectable due to unknown error", "fail");
		}
	}
	
	public void selectValueByName(String name, String value) {
		try {
			WebElement wb = driver.findElementByName(name);
			Select element = new Select(wb);
			element.selectByValue(value);
			//System.out.println("For the id "+name+" from the drop down the visible text "+value+" is selected");
			reportStep("For the id "+name+" from the drop down the visible text "+value+" is selected", "pass");
		} catch (ElementNotSelectableException e) {
			//System.err.println("For the id "+name+" from the drop down the visible text "+value+" is not selectable");
			reportStep("For the id "+name+" from the drop down the visible text "+value+" is not selectable", "fail");
		} catch (WebDriverException e) {
			//System.err.println("For the id "+name+" from the drop down the visible text "+value+" is not selectable due to unknown error");
			reportStep("For the id "+name+" from the drop down the visible text "+value+" is not selectable due to unknown error", "fail");
		}
		
	}

	
	public void selectVisibileTextByName(String name, String value) {
		
		try {
			WebElement wb = driver.findElementByName(name);
			Select element = new Select(wb);
			element.selectByVisibleText(value);
			//System.out.println("For the id "+name+" from the drop down the visible text "+value+" is selected");
			reportStep("For the id "+name+" from the drop down the visible text "+value+" is selected", "pass");
		} catch (ElementNotSelectableException e) {
			//System.err.println("For the id "+name+" from the drop down the visible text "+value+" is not selectable");
			reportStep("For the id "+name+" from the drop down the visible text "+value+" is not selectable", "fail");
		}catch (WebDriverException e) {
			//System.err.println("For the id "+name+" from the drop down the visible text "+value+" is not selectable due to unknown error");
			reportStep("For the id "+name+" from the drop down the visible text "+value+" is not selectable due to unknown error", "fail");
		}

	}

	public void selectIndexByName(String name, int value) {
	
		try {
			WebElement wb = driver.findElementByName(name);
			Select element = new Select(wb);
			element.selectByIndex(value);
			//System.out.println("For the id "+name+" from the drop down the visible text "+value+" is selected");
			reportStep("For the id "+name+" from the drop down the visible text "+value+" is selected", "pass");
		} catch (ElementNotSelectableException e) {
			//System.err.println("For the id "+name+" from the drop down the visible text "+value+" is not selectable");
			reportStep("For the id "+name+" from the drop down the visible text "+value+" is not selectable", "fail");
		} catch (WebDriverException e) {
			//System.err.println("For the id "+name+" from the drop down the visible text "+value+" is not selectable due to unknown error");
			reportStep("For the id "+name+" from the drop down the visible text "+value+" is not selectable due to unknown error", "fail");
		}
	
	}
	
	public void mouseHoverByXpath(String xpath) {
		try {
			Actions builder = new Actions(driver); 
			WebElement wb = driver.findElementByXPath(xpath);
			builder.moveToElement(wb).perform();
			reportStep("Able to hover the mouse pointer for the xpath "+xpath, "pass");	
		}catch (WebDriverException e) {
			System.err.println("Unable to hover the mouse pointer for the xpath "+xpath+" due to unknown error");
			reportStep("Unable to hover the mouse pointer for the xpath "+xpath+" due to unknown error", "fail");
		}
	}
	public void switchFrameByxpath(String xpath) {
		
		try {
			WebElement frame = driver.findElementByXPath(xpath);
			driver.switchTo().frame(frame);
			//System.out.println("Switched to the other frame with the xpath "+xpath);
			reportStep("Switched to the other frame with the xpath "+xpath, "pass");
		} catch (NoSuchFrameException e) {
			//System.err.println("Unable to switch to the frame with xpath "+xpath+" since the frame does not exist");
			reportStep("Unable to switch to the frame with xpath "+xpath+" since the frame does not exist", "fail");
		}catch (WebDriverException e) {
			//System.err.println("Unable to switch to the frame with xpath "+xpath+"due to unknown error");
			reportStep("Unable to switch to the frame with xpath "+xpath+"due to unknown error", "fail");
		} 
	
	}

	public void switchFrameByIndex(int value) {
		
		try {
			driver.switchTo().frame(value);
			//System.out.println("Switched to the other frame with the index "+value);
			reportStep("Switched to the other frame with the index "+value, "pass");
		} catch (NoSuchFrameException e) {
			//System.err.println("Unable to switch to the frame with index "+value+" since the frame does not exist");
			reportStep("Unable to switch to the frame with index "+value+" since the frame does not exist", "fail");
		}catch (WebDriverException e) {
			//System.err.println("Unable to switch to the frame with index "+value+"due to unknown error");
			reportStep("Unable to switch to the frame with index "+value+"due to unknown error", "fail");
		} 

	}
	
	public void switchFrameById(String id) {
			
			try {
				driver.switchTo().frame(id);
				//System.out.println("Switched to the other frame with the index "+value);
				reportStep("Switched to the other frame with the id "+id, "pass");
			} catch (NoSuchFrameException e) {
				//System.err.println("Unable to switch to the frame with index "+value+" since the frame does not exist");
				reportStep("Unable to switch to the frame with id "+id+" since the frame does not exist", "fail");
			}catch (WebDriverException e) {
				//System.err.println("Unable to switch to the frame with index "+value+"due to unknown error");
				reportStep("Unable to switch to the frame with id "+id+"due to unknown error", "fail");
			} 
	
		}

	public void switchMainFrame() {
		try {	
			driver.switchTo().defaultContent();
			//System.out.println("Switched to the Main frame");
			reportStep("Switched to the Main frame", "pass");
		} catch (NoSuchFrameException e) {
			//System.err.println("Unable to switch to the Main frame");
			reportStep("Unable to switch to the Main frame", "fail");
		}catch (WebDriverException e) {
			//System.err.println("Unable to switch to the Main frame due to unknown error");
			reportStep("Unable to switch to the Main frame due to unknown error", "fail");
		} 

	}

	public void switchToParentWindow() {
		
		try {
				Set<String> windows = driver.getWindowHandles();
				
				for(String winhan : windows) {
					driver.switchTo().window(winhan);
					break;
				}
			//System.out.println("Switched to parent window");
			reportStep("Switched to parent window", "pass");
		} catch (NoSuchWindowException e) {
			//System.err.println("Unable to switch to parent window since it does not exist");
			reportStep("Unable to switch to parent window since it does not exist", "fail");
		} catch (WebDriverException e) {
			//System.err.println("Unable to switch to Parent window due to unknown error");
			reportStep("Unable to switch to Parent window due to unknown error", "fail");
		} 
		
	}

	public void switchToLastWindow() {
		
		try {
			Set<String> windows = driver.getWindowHandles();
			
			for(String winhan : windows) {
				driver.switchTo().window(winhan);
			}
			//System.out.println("Switched to last window");
			reportStep("Switched to last window", "pass");
		} catch (NoSuchWindowException e) {
			//System.err.println("Unable to switch to last window since it does not exist");
			reportStep("Unable to switch to last window since it does not exist", "fail");
		} catch (WebDriverException e) {
			//System.err.println("Unable to switch to last window due to unknown error");
			reportStep("Unable to switch to last window due to unknown error", "fail");
		} 
		
	}

	public void acceptAlert() {
		
		try {
			driver.switchTo().alert().accept();
			//System.out.println("Alert is accepted");
			reportStep("Alert is accepted", "pass");
		} catch (NoAlertPresentException e) {
			//System.err.println("No alert is present in the browser to accept it");
			reportStep("No alert is present in the browser to accept it", "fail");
		} catch (UnhandledAlertException e) {
			//System.err.println("Unable to accept the alert present in the browser");
			reportStep("Unable to accept the alert present in the browser", "fail");
		} catch (WebDriverException e) {
			//System.err.println("Alert is not accepted due to unknown error");
			reportStep("Alert is not accepted due to unknown error", "fail");
		} 
		
	}

	public void dismissAlert() {
		
		try {
			driver.switchTo().alert().dismiss();
			//System.out.println("Alert is dismissed");
			reportStep("Alert is dismissed", "pass");
		} catch (NoAlertPresentException e) {
			//System.err.println("No alert is present in the browser to dismiss it");
			reportStep("No alert is present in the browser to dismiss it", "fail");
		} catch (UnhandledAlertException e) {
			//System.err.println("Unable to dismiss the alert present in the browser");
			reportStep("Unable to dismiss the alert present in the browser", "fail");
		} catch (WebDriverException e) {
			//System.err.println("Alert is not dismissed due to unknown error");
			reportStep("Alert is not dismissed due to unknown error", "fail");
		} 
	}

	public String getAlertText() {
		
		String alerttext = null;
		try {
			 alerttext = driver.switchTo().alert().getText();
			//System.out.println("Alert text is "+alerttext);
			reportStep("Alert text is "+alerttext, "pass",false);
		} catch (NoAlertPresentException e) {
			//System.err.println("No alert is present in the browser to get the alert text");
			reportStep("No alert is present in the browser to get the alert text", "fail",false);
		} catch (UnhandledAlertException e) {
			//System.err.println("Unable to get text from the alert present in the browser");
			reportStep("Unable to get text from the alert present in the browser", "fail",false);
		} catch (WebDriverException e) {
			//System.err.println("Alert text is not able to get due to unknown error");
			reportStep("Alert text is not able to get due to unknown error", "fail",false);
		} 
		
		return alerttext;
	}

	public void enterTextInAlert(String text) {

		try {
			  driver.switchTo().alert().sendKeys(text);
			//System.out.println(text+" is entered in alert box");
			reportStep(text+" is entered in alert box", "pass",false);
		} catch (NoAlertPresentException e) {
			//System.err.println("No alert is present in the browser to get the alert text");
			reportStep("No alert is present in the browser to enter the text", "fail",false);
		} catch (UnhandledAlertException e) {
			//System.err.println("Unable to enter text in the alert present in the browser");
			reportStep("Unable to enter text in the alert present in the browser", "fail",false);
		} catch (WebDriverException e) {
			//System.err.println("Text is not able to enter in alert box due to unknown error");
			reportStep("Text is not able to enter in alert box due to unknown error", "fail",false);
		} 
		
	}
	public long takeSnap() {
		
		long snap = 0;
		try {
			snap = (long) Math.floor((Math.random()*1000000)+1000000);
					
			File temp = driver.getScreenshotAs(OutputType.FILE);
			File dest = new File("./report/screenshot/"+snap+".png");
			FileUtils.copyFile(temp, dest);
		} catch (IOException e) {
			//System.err.println("Unable to capture screenshot due to IOException");
			reportStep("Unable to capture screenshot due to IOException", "fail");
		} catch(ScreenshotException e) {
			//System.err.println("Unable to capture the screenshot");
			reportStep("Unable to capture the screenshot", "fail");
		}
		
		return snap;
		
	}

	public void closeBrowser() {

		try {
			driver.close();
			//System.out.println("The current window is closed");
			reportStep("The current window is closed", "pass",false);
		} catch (WebDriverException e) {
			//System.err.println("Unable to close the current window");
			reportStep("Unable to close the current window", "fail",false);
		}
		
	}

	public void closeAllBrowsers() {

		try {
			driver.quit();
			//System.out.println("The Browser is closed");
			reportStep("The Browser is closed", "pass",false);
		} catch (WebDriverException e) {
			//System.err.println("Unable to close the Browser");
			reportStep("Unable to close the Browser", "fail",false);
		}
		
		
	}

	public void waittime(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void refreshWindow() {
		try {
			driver.navigate().refresh();
			//System.out.println("The current window is refreshed");
			reportStep("The current window is refreshed", "pass",false);
		} catch (WebDriverException e) {
			//System.err.println("Unable to refresh the current window");
			reportStep("Unable to refresh the current window", "fail",false);
		}
		
	}
			
}
