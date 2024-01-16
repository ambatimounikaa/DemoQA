package packTests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Windows;

public class TestWindows {
	WebDriver dr;
	Windows w;
	
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
		dr.get("https://demoqa.com/browser-windows");
		dr.manage().window().maximize();
	}
	
	@Test
	public void testNewTab() {
		w= new Windows(dr);
		w.handleNewTab();
	}
	
	@Test(priority=1)
	public void testNewWindow() {
		w= new Windows(dr);
		w.handleNewWindow();
	}
	
	@Test(priority=2)
	public void testMessagedWindow() {
		w= new Windows(dr);
		w.scrollDown();
		w.handleMessagedWindow();
	}
	
	@AfterTest
	public void tearDown() {
		dr.close();
	}

}
