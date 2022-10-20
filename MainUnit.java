package automation;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver; ???
import org.junit.Test;

public class MainUnit {
	
	public static WebDriver chDriver = null;
	// WebDriver ffDriver = null; //firefox
	
	
	@BeforeClass // annotation so the program starts not in the beginning
	
	public static void beforeTest() {
		
		System.out.println("Before Class - Start");
		//driver test run
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\micha\\Desktop\\jar\\chromedriver.exe"); // the path of my chrome driver
		//System.setProperty("webdriver.gecodriver.driver", "C:\\Users\\micha\\Desktop\\jar\\gecodriver.exe");
		
		chDriver = new ChromeDriver();
		//ffDriver = new FirefoxDriver();
		
		chDriver.manage().window().maximize();// maximize the webpage	
		
	}
	
	@Test
	public void test() throws InterruptedException {
		System.out.println("MainUnit - Start");
		chDriver.get("file:///C:/Users/micha/Desktop/jar/HTML_Project.html");//launch the url on our browser
		
		HomePage homep = new HomePage();//this is the test function from homepage class
		homep.test(chDriver);
		//opens the web again but I don't want to. I want to preserve the input I inserted in the homepage
		//chDriver.get("file:///C:/Users/micha/Desktop/jar/HTML_Project.html");
		
		NextPage nextp = new NextPage();//creating nextpage test
		nextp.test(chDriver);
		
		chDriver.navigate().back();//returning to homepage
		
		WindyPage windyp = new WindyPage();
		windyp.test(chDriver);
		
		chDriver.navigate().back();//returning to homepage
		
		TeraSantaPage tsp = new TeraSantaPage();
		tsp.test(chDriver);
		
		chDriver.navigate().back();//returning to homepage
		
		JavaBookPage jbp = new JavaBookPage();
		jbp.test(chDriver);

		chDriver.navigate().back(); //returning to homepage
		chDriver.navigate().refresh();//refreshing the homepage
		
		YouTubePage ytp = new YouTubePage();
		ytp.test(chDriver);
		
	
	}
	
	@AfterClass 
	public static void afterTest( ) {
		System.out.println("After Class - Start");
		
		
		/*chDriver.quit(); //closes chrome
		 chDriver.close(); //closes window
		 chDriver.navigate().back();
		 chDriver.navigate().forward();
	     chDriver.navigate().refresh(); 
		 */
		
		/* chDriver.get("file:///C:/Users/micha/Desktop/jar/HTML_Project.html");
		 * chDriver.switchTo().newWindow(WindowType.TAB); //WhindowType.WINDOW for opening a new window
		 * chDriver.navigate().to("https://www.google.com/);
		 */

	}

}
