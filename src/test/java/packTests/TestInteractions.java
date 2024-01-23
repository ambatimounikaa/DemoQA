package packTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Interactions;

public class TestInteractions {
	
	WebDriver dr;
	Interactions i ;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		dr = new ChromeDriver();
		dr.get("https://demoqa.com/sortable");
		dr.manage().window().maximize();
	}
	
	@Test
	public void checkSortable() throws InterruptedException {
		i = new Interactions(dr);
		i.sortable();
		
	}
	
	@Test(priority=1)
	public void checkSelectable() {
		i = new Interactions(dr);
		i.scrollDown();
		i.selectable();
		
	}
	
	
	
	@Test(priority=2)
	public void checkDroppable() throws InterruptedException {
		i= new Interactions(dr);
		i.scrollDown();
		i.droppable();
		i.droppable1();
		i.droppable2();
		i.droppable3();
	}
	
	@AfterTest
	public void tearDown() {
		dr.close();
	}
}
