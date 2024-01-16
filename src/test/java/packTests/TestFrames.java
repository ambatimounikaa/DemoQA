package packTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Frames;
import pageObjects.NestedFrames;

public class TestFrames {
	WebDriver dr;
	
	Frames f;
	NestedFrames nf;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		dr = new ChromeDriver();
		dr.get("https://demoqa.com/frames");
		dr.manage().window().maximize();
	}
	
	@Test
	public void testFrameOne() {
		f = new Frames(dr);
		f.countFrames();
		f.frameOne();
		
	}
	
	@Test(priority=1)
	public void testFrameTwo() {
		f = new Frames(dr);
		f.frameTwo();
		f.scrollDown();
	}
	
	@Test(priority=2)
	public void testNestedFrames() {
		nf = new NestedFrames(dr);
		nf.moveToNestedFrames();
		nf.parentFrame();
		nf.childFrame();
	}
	
	
	@AfterTest
	public void tearDown() {
		dr.close();
	}

}
