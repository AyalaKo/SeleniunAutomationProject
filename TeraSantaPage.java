package automation;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TeraSantaPage {

	@Test
	public void test(WebDriver driver) {
		System.out.println("TeraSantaPage - test start");
		
		WebElement nextpWebElement = null;
		nextpWebElement = driver.findElement(By.linkText("Tera Santa"));
		System.out.println(nextpWebElement.getText()); 
		nextpWebElement.click(); //clicking on the link next page
	}

}
