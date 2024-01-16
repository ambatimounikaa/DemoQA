package packTests;

import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Alerts;

public class TestAlerts {
	WebDriver dr;
	Alerts a ;
	
	
	@BeforeTest
	public void setUp() {
		System.out.println("Enter browser of your choice");
		Scanner sc = new Scanner(System.in);
		String browser = sc.next();
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			dr = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
	        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
	        dr = new EdgeDriver();
		}
		dr.get("https://demoqa.com/alerts");
		dr.manage().window().maximize();
	}
	
	@Test
	public void buttontoSeeAlert() {
		a = new Alerts(dr);
		a.handleClickOne();
		
	}
	
	@Test(priority=1)
	public void timerAlerts() throws InterruptedException {
		a = new Alerts(dr);
		a.handleClickTwo();
	}
	
	@Test(priority=2)
	public void confirmAlerts() {
		a = new Alerts(dr);
		a.scrollDown();
		a.handleClickThree();
	}
	
	@Test(priority=3,dataProvider ="dataprovider")
	public void promptAlerts(String s) {
		a = new Alerts(dr);
		a.handleClickFour(s);
	}
	
	@DataProvider(name="dataprovider")
	public Object[][] dpMethod(){
        return new Object[][] {{"Mounika Ambati"}};
    }
	
	@AfterTest
	public void tearDown() {
		dr.close();
	}

}
