package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Frames {
	WebDriver dr;
	
	String  textInFrameOne, textInFrameTwo;
	By frame1 = By.id("frame1");
	By frame2 = By.id("frame2");
	By textOne = By.xpath("//h1[@id='sampleHeading'][1]");
	By textTwo = By.xpath("//h1[@id='sampleHeading'][1]");

	
	public Frames(WebDriver dr) {
		this.dr=dr;
	}
	
	//method to scroll down the web page
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor)dr;
        js.executeScript("window.scrollBy(0,600)");

	}
	public void countFrames() {
		List<WebElement> li = dr.findElements(By.tagName("iframe"));
		System.out.println(li.size()+" Frames present in current window");
		
	}
	public void frameOne() {
		dr.switchTo().frame(dr.findElement(frame1));
		textInFrameOne = dr.findElement(textOne).getText();
		Assert.assertEquals("This is a sample page", textInFrameOne);
		dr.switchTo().defaultContent();
	}
	
	public void frameTwo() {
		dr.switchTo().frame(dr.findElement(frame2));
		textInFrameTwo = dr.findElement(textTwo).getText();
		Assert.assertEquals("This is a sample page", textInFrameTwo);
		dr.switchTo().defaultContent();
		
	}
 
}
