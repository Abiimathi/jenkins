package projImplementation;

import java.util.List;

import org.openqa.selenium.Keys;

public interface Wrappers {
	/**
	 * This method will launch the given browser and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Abimathi
	 * @param browser - The browser of the application to be launched
	 * @param url - The url with http or https
	 * @throws Exception 
	 * 
	 */
	public void invokeApp(String browser, String url);
	
	/**
	 * This method will clear the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Abimathi
	 * @return 
	 * @throws Exception 
	 */
	
	public void clearById(String idValue);
	

	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Abimathi
	 * @return 
	 * @throws Exception 
	 */
	
	public void enterById(String idValue, String data);
	
	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Abimathi
	 * @return 
	 * @throws Exception 
	 */
	public void enterById(String idValue, Keys key, String KeyName);
	
	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param xpath - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Abimathi
	 * @return 
	 * @throws Exception 
	 */
	public void enterByXpath(String xpath, Keys key, String keyName);
	
	/**
	 * This method will enter the value to the text field using name attribute to locate
	 * 
	 * @param nameValue - name of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Abimathi
	 */
	public void enterByName(String nameValue, String data) ;	
	
	/**
	 * This method will enter the value to the text field using xpath attribute to locate
	 * 
	 * @param xpathValue - name of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Abimathi
	 */
	public void enterByXpath(String xpathValue, String data);


	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author Abimathi
	 */
	public void verifyTitle(String title);
	
	/**
	 * This method will verify the given text
	 * @param id - The locator of the object in id
	 * @param text  - The text to be verified
	 * @author Abimathi
	 */
	public void verifyTextById(String id, String text);
	
	/**
	 * This method will verify the given text with exact match
	 * @param xpath - The locator of the object in id
	 * @param text  - The text to be verified
	 * @author Abimathi
	 */
	public void verifyTextByXpath(String xpath, String text);
	
	/**
	 * This method will verify the given text with partial match
	 * @param id - The locator of the object in id
	 * @param text  - The text to be verified
	 * @author Abimathi
	 */
	public void verifyTextContainsById(String id, String text);
	
	/**
	 * This method will verify the given text with partial match
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Abimathi
	 */
	public void verifyTextContainsByXpath(String xpath, String text);

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Abimathi
	 */
	public void clickById(String id) ;

	/**
	 * This method will click the element using ClassName as locator
	 * @param class  The class (locator) of the element to be clicked
	 * @author Abimathi
	 * @throws Exception 
	 */
	public void clickByClassName(String classVal);
	
	/**
	 * This method will click the element using name as locator
	 * @param name  The name (locator) of the element to be clicked
	 * @author Abimathi
	 */
	public void clickByName(String name) ;
	

	/**
	 * This method will click the element using link name as locator and do take snap
	 * @param name  The link name (locator) of the element to be clicked
	 * @author Abimathi
	 */
	public void clickByLink(String name);
	
	/**
	 * This method will click the element using link name as locator and do not take snap
	 * @param name  The link name (locator) of the element to be clicked
	 * @author Abimathi
	 */
	public void clickByLinkNoSnap(String name);

	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Abimathi
	 */
	public void clickByXpath(String xpathVal);
	
	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Abimathi
	 */
	public void clickByXpathNoSnap(String xpathVal);
	
	/**
	 * This method will get the text of the element using id as locator
	 * @param xpathVal  The id (locator) of the element 
	 * @author Abimathi
	 */
	public String getTextById(String idVal);

	/**
	 * This method will get the text of the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element 
	 * @author Abimathi
	 */
	public String getTextByXpath(String xpathVal);

	/**
	 * This method will select the drop down  text using id as locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (text) from the dropdown 
	 * @author Abimathi
	 */
	public void selectVisibileTextById(String id, String value);
	
	/**
	 * This method will select the drop down using index as id locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (index) from the dropdown 
	 * @author Abimathi
	 */
	public void selectIndexById(String id, int value);
	
	/**
	 * This method will select the drop down using value as id locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (index) from the dropdown 
	 * @author Abimathi
	 */
	public void selectValueById(String id, String value);
	
	/**
	 * This method will select the drop down  text using xpat as locator
	 * @param xpath The xpath (locator) of the drop down element
	 * @param value The value to be selected (text) from the dropdown 
	 * @author Abimathi
	 */
	public void selectVisibileTextByXpath(String xpath, String value);
	
	/**
	 * This method will select the drop down using index as xpath locator
	 * @param xpath The xpath (locator) of the drop down element
	 * @param value The value to be selected (index) from the dropdown 
	 * @author Abimathi
	 */
	public void selectIndexByXpath(String xpath, int value);
	
	/**
	 * This method will select the drop down using value as xpath locator
	 * @param xpath The xpath (locator) of the drop down element
	 * @param value The value to be selected (index) from the dropdown 
	 * @author Abimathi
	 */
	public void selectValueByXpath(String xpath, String value);
	
	/**
	 * This method will select the drop down using index as name locator
	 * @param name The name (locator) of the drop down element
	 * @param value The value to be selected (index) from the dropdown 
	 * @author Abimathi
	 */
	public void selectIndexByName(String name, int value);
	
	/**
	 * This method will select the drop down  text using name as locator
	 * @param name The name (locator) of the drop down element
	 * @param value The value to be selected (text) from the dropdown 
	 * @author Abimathi
	 */
	public void selectVisibileTextByName(String name, String value);
	
	/**
	 * This method will select the drop down using value as name locator
	 * @param name The name (locator) of the drop down element
	 * @param value The value to be selected (index) from the dropdown 
	 * @author Abimathi
	 */
	public void selectValueByName(String name, String value);
	
	/**
	 * This method will hover the mouse pointer by xpath
	 * @author Abimathi
	 */
	public void mouseHoverByXpath( String xpath);
	
	/**
	 * This method will switch to the parent Window
	 * @author Abimathi
	 */
	public void switchToParentWindow();
	
	/**
	 * This method will move the control to the last window
	 * @author Abimathi
	 */
	public void switchToLastWindow();
	
	/**
	 * This method will switch the frame by xapth
	 * @author Abimathi
	 */
	public void switchFrameByxpath(String xpath);
	
	/**
	 * This method will switch the frame by index
	 * @author Abimathi
	 */
	public void switchFrameByIndex(int value);
	
	/**
	 * This method will switch the frame by id
	 * @author Abimathi
	 */
	public void switchFrameById(String id);
	
	/**
	 * This method will switch to the parent frame
	 * @author Abimathi
	 */
	public void switchMainFrame();
	
	/**
	 * This method will accept the alert opened
	 * @author Abimathi
	 */
	public void acceptAlert();
	
	/**
	 * This method will dismiss the alert opened
	 * @author Abimathi
	 */
	public void dismissAlert();
	
	/**
	 * This method will return the text of the alert
	 * @author Abimathi
	 */
	public String getAlertText();
	
	/**
	 * This method will enter the text in the alert
	 * @author Abimathi
	 */
	public void enterTextInAlert(String text);
		
	/**
	 * This method will close the active window
	 * @author Abimathi
	 */
	public void closeBrowser();
	
	/**
	 * This method will close all the browsers
	 * @author Abimathi
	 */
	public void closeAllBrowsers();
	
	/**
	 * This method will wait for the time provided
	 * @author Abimathi
	 */
	public void waittime(long time);
	
	/**
	 * This method will refresh the window
	 * @author Abimathi
	 */
	public void refreshWindow();
 

}
