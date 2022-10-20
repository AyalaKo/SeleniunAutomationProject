package automation;

import java.lang.Thread;
import java.util.List;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class HomePage {

	@Test
	public void test(WebDriver chromeDriver) throws InterruptedException {

		
		System.out.println("HomePage - test start");
		String expTitle = "Automation Project";
		//calling web title:
		String actTitle = chromeDriver.getTitle();
		Assert.assertEquals("Error in title", expTitle, actTitle);// the program compares between the title of the html to the expected title
		
		WebElement hpWebElement = null;
		hpWebElement = chromeDriver.findElement(By.tagName("h1"));
		System.out.println(hpWebElement.getText());
		Assert.assertEquals("Error in heading", "Student Details", hpWebElement.getText());
		
		
		/*
		//other ways of comparing:
		
		String expectedValue = "Details of student";
		String actualValue = hpWebElement.getText();
		if (actualValue.equals(expectedValue)) {
			System.out.println("Element Text was found");
		}
		else {
			System.out.println("Element text was NOT found, Text was: " + actualValue + " But was expected: " + expectedValue);
		}
		
		//another way
		 
		if (hpWebElement.getTagName().equals("h1")) {
			System.out.println("Tag name was found");
		}
		else {
			System.out.println("Tag name was NOT found");
		}
		*/
		
		//Personal Information
		//fill input:
		chromeDriver.findElement(By.name("fname")).sendKeys("Ayala"); //first name
		String firstName = chromeDriver.findElement(By.name("fname")).getAttribute("value");//getting the value of my input for later use
		chromeDriver.findElement(By.name("lname")).sendKeys("Kovelman"); //last name
		String lastName = chromeDriver.findElement(By.name("lname")).getAttribute("value");
		chromeDriver.findElement(By.cssSelector("input#email")).sendKeys("someone11@mail.com");//email
		String email = chromeDriver.findElement(By.cssSelector("input#email")).getAttribute("value");
		chromeDriver.findElement(By.cssSelector("input#phone")).sendKeys("574-23-818");//phone
		String phoneNu = chromeDriver.findElement(By.cssSelector("input#phone")).getAttribute("value");
		
		//dropdown:
		//select by visible text- City
		hpWebElement = chromeDriver.findElement(By.name("City"));
		Select citySelect = new Select(hpWebElement);
		citySelect.selectByVisibleText("Tel Aviv");
		
		//select by value- Mobile (area code)
		hpWebElement = chromeDriver.findElement(By.name("areaCode"));
		Select aeraCodeSelect = new Select(hpWebElement);
		aeraCodeSelect.selectByValue("54");
		
		
		//table:
		//checkbox
		chromeDriver.findElement(By.name("math")).click();
		chromeDriver.findElement(By.name("pyhs")).click();
		chromeDriver.findElement(By.name("bio")).click();
		chromeDriver.findElement(By.name("chem")).click();
		chromeDriver.findElement(By.name("eng")).click();
		
		//radio
		chromeDriver.findElement(By.id("fe")).click();
		chromeDriver.findElement(By.id("ma")).click();
		chromeDriver.findElement(By.id("ot")).click();
		chromeDriver.findElement(By.id("po")).click();
		chromeDriver.findElement(By.id("d")).click();
		

		//HTML buttons
		//chromeDriver.findElement(By.id("CB")).click();//clear button
		//chromeDriver.findElement(By.cssSelector("input[value=OK]")).click();//ok button
		//chromeDriver.findElement(By.id("CB")).click();//send button
		
		//JS Buttons
		//Prompt button 
		chromeDriver.findElement(By.tagName("button")).click();//click on button
		Alert alert = chromeDriver.switchTo().alert();//switching from homepage to alert window
		alert.sendKeys("This actiually works!");//input
		//alert.dismiss(); //if we want to cancel
		alert.accept();// click on ok button
		
		//progress element
		String pStart = chromeDriver.findElement(By.id("startLoad")).getText();
		System.out.println(pStart);//printing paragraph text
		chromeDriver.findElement(By.xpath("//fieldset[1]/button[2]")).click();//click on start loading
		Thread.sleep(5100);//waiting for 5.1 seconds before continuing for the loading to finish
		String pFinish = chromeDriver.findElement(By.id("startLoad")).getText();
		System.out.println(pFinish);//printing changed paragraph text
		
		
		//Lists:
		//list of more than one element
		
		//list of h1
		List <WebElement> elements = null;
		elements = chromeDriver.findElements(By.tagName("h1"));
		int numOfElements=elements.size();
		System.out.println("there are " + numOfElements + " H1 elements");
		
		//print the list of h1
		for (int i=0; i < numOfElements; i++ ) {
			System.out.println("The text is: " + elements.get(i).getText());
		}
		
		//list of td
		elements = chromeDriver.findElements(By.tagName("td"));
		numOfElements=elements.size();
		System.out.println("there are " + numOfElements + " td elements");
		
		//print list of td
		for (int i=0; i < numOfElements; i++ ) {
			System.out.println("The text is: " + elements.get(i).getText());
		
		}
		
		//print content of each table
		for (int i=0; i<chromeDriver.findElements(By.tagName("table")).size(); i++) {
			System.out.println("The text from table is: " + chromeDriver.findElements(By.tagName("table")).get(i).getText());
		}
		
		//list of gender
		elements = chromeDriver.findElements(By.name("gender"));
		numOfElements=elements.size();
		System.out.println("there are " + numOfElements + " Gender elements");
		
		//print content of each gender
		//!!!! because some of the gender are outside of the table tag (written incorrectly for HtML) , the list will not print the items
		for (int i=0; i<chromeDriver.findElements(By.name("gender")).size(); i++) {
			System.out.println("The text from gender is: " + chromeDriver.findElements(By.name("gender")).get(i).getText());
		}
		
		//print list of links
		for (int i=0; i<chromeDriver.findElements(By.tagName("a")).size(); i++) {
			System.out.println("Link "+ (i+1) + " is: " + chromeDriver.findElements(By.tagName("a")).get(i).getText());
		}
		
	
		//validating certain element is displayed
	
		boolean displayed = chromeDriver.findElement(By.tagName("h1")).isDisplayed();
		if (displayed) {
			System.out.println("Element was displayed");
		}
		else {
			System.out.println("Element was not displayed");
		}
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		//validating input boxes still have input when returning to the home page from next page link
		
		WebElement nextpWebElement = null;
		nextpWebElement = chromeDriver.findElement(By.linkText("Next Page"));
		System.out.println("We are navigating to " + nextpWebElement.getText() +" And back to HomePage"); //printing out the link text
		nextpWebElement.click(); //clicking on the link next page
		
		chromeDriver.navigate().back();//navigating back to home page

		if (chromeDriver.findElement(By.name("fname")).getAttribute("value").equals(firstName)) { //getting the input of first name and comparing it to expected value
			System.out.println("First name was found");
		}
		else {
			System.out.println("First name was NOT found");
		}
		
		if (chromeDriver.findElement(By.name("lname")).getAttribute("value").equals(lastName)) { //getting the input of last name and comparing it to expected value
			System.out.println("Last name was found");
		}
		else {
			System.out.println("Last name was NOT found");
		}
		
		if (chromeDriver.findElement(By.cssSelector("input#email")).getAttribute("value").equals(email)) { //getting the input of email and comparing it to expected value
			System.out.println("Email was found");
		}
		else {
			System.out.println("Email was NOT found");
		}
		if (chromeDriver.findElement(By.cssSelector("input#phone")).getAttribute("value").equals(phoneNu)) { //getting the input of phone and comparing it to expected value
			System.out.println("Phone Number was found");
		}
		else {
			System.out.println("Phone Number was NOT found");
		}
		
	}

}
