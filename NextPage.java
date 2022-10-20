package automation;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class NextPage {

	@Test
	public void test(WebDriver chrDriver) {
		
		System.out.println("NextPage - test start");
		
		WebElement nextpWebElement = null;
		nextpWebElement = chrDriver.findElement(By.linkText("Next Page"));
		System.out.println(nextpWebElement.getText()); 
		nextpWebElement.click(); //clicking on the link next page
		
		String oldTitle = chrDriver.getTitle(); //putting the title name into a string
		String expTitle = "Next Page";
		Assert.assertEquals("Error in title", expTitle, oldTitle);//checking that the title is as expected
		
		chrDriver.findElement(By.tagName("button")).click(); //clicking on the button
		String newTitle = chrDriver.getTitle(); //putting the changed title into a string
		expTitle = "Finish";
		Assert.assertEquals("Error in title", expTitle, newTitle);//checking that the title is as expected
		System.out.println("the old title was: " + oldTitle + ", The new Title is: " + newTitle);
		
	}

}
