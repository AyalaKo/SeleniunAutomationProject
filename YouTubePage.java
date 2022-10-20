package automation;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTubePage {

	@Test
	public void test(WebDriver driver) {
System.out.println("YouTubePage - test start");
		
		WebElement ytpWebElement = null;
		ytpWebElement = driver.findElement(By.linkText("YouTube"));
		System.out.println(ytpWebElement.getText()); 
		ytpWebElement.click(); //clicking on the link youtube
		
		WebDriverWait wait = new WebDriverWait(driver,10);// creating waiting element 
		WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#search")));
		searchField.sendKeys("gene kelly");//insert input in search field
		
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#search-icon-legacy")));
		searchButton.click();//clicking on search button


	}
	

}
