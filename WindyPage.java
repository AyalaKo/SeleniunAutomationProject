package automation;


import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindyPage {

	@Test
	public void test( WebDriver driver) {
		System.out.println("WindyPage - test start");
		
		WebElement windypWebElement = null;
		windypWebElement = driver.findElement(By.linkText("Windy"));
		System.out.println(windypWebElement.getText()); 
		windypWebElement.click(); //clicking on the link windy
	}

}



/* 
 * !!!! reminders !!!!
 * web functions
 * .getTitle() gets the title of the webpage
 * .getCurrentUrl() gets the address of the webpage
 * .getPageSource() gets the html of the webpage
 * .navigate().back() if we were navigating to another page it will navigate back
 * .navigate().forward() navigating to forward page we came back from
 * 
 * elements
 * .findElement(By.LocatorType("LocatorValue"))
 * locator types:
 * id, name, className, tagName, linkText, partialLinkText, xPath, cssSelector
 * the value of cssSelector- tag and id --> "tag#id"
 * 							 tag and class --> "tag.class"
 * 							 tag and attribute --> "tag[attribute=value]"
 * 							 tag, class and attribute --> "tag.class[attribute=value]"
 * relative xpath- //tagname[@attribute='value']
 * the value we get from the findElement is an element thus we can't assign an object like int or string.
 * we will assign WebElement to an object
 * for example: 
 * WebElement hpWebElement = null; 
 * hpWebElement = chromeDriver.findElement(By.tagName("h1"));
 * or WebElememt hpWebElement = chromeDriver.findElement(By.tagName("h1"));
 * when you call an element on a webpage that has more than one of the same locatorValue then it will get the first one.
 * for example tagName of h1 when we have more than one h1 in the html it will get the first one.
 * if we want more than on element then we use the .findElements
 * the find elements get use a list 
 * List<WebElement> variableName = chromeDriver.findElement(by.tagName("h1"));
 * to get the first element: 
 * WebElement firstH1 = variableName.get(0); the first begins with index 0
 * variableName.size(); gives the number of h1 in my webpage
 * 
 * operation on element
 * .sendKeys("") input in element 
 * .click() clicking on a button
 * for example:
 *  WebElement hpWebElement = null;
 * 	hpWebElement = chromeDriver.findElement(By.name("fname"));
 *  hpWebElement.sendKeys("Ayala");
 *  or if you don't want to get the information in a temporary object, you can write instead:
 *  chromeDriver.findElement(By.name("fname")).sendKeys("ayala");
 *  if you want to wait between operations you can delay the running time between actions:
 *  Thread.sleep(1000); this will give us 1000 milliseconds = 1 second.
 *  
 *  dropdown
 *  choose dropdown by visible text .selectByVisibleText("text");
 *  by index (starts from 0) .selectByIndex(1);
 *  
 *  validation:
 *  functions for validation
 *  .isDisplayed()
 *  .isEnabled()
 *  .getText()
 *  when trying to compare you can write if statement
 *  examples above
 *  
 */

