package automation;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaBookPage {

	@Test
	public void test(WebDriver driver) {
		System.out.println("JavaBookPage - test start");
		
		WebElement jbpWebElement = null;
		jbpWebElement = driver.findElement(By.linkText("Java Book"));
		System.out.println(jbpWebElement.getText()); 
		jbpWebElement.click(); //clicking on the link java book
	}

}
