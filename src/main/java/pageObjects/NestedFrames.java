package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;


public class NestedFrames {
		
	WebDriver dr;
	By nf = By.xpath("//ul/li/span[contains(text(),'Nested Frames')]");
	By frame1 = By.id("frame1");
	By frame2 = By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']");
	
	public NestedFrames(WebDriver dr){
		this.dr = dr;
	}
	
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor)dr;
        js.executeScript("window.scrollBy(0,300)");

	}
	
	public void moveToNestedFrames() {
		dr.findElement(nf).click();
	}

	public void parentFrame() {
		dr.switchTo().frame(dr.findElement(frame1));
		System.out.println("Inside Parent Frame");
	}
	
	public void childFrame() {
		dr.switchTo().frame(dr.findElement(frame2));
		System.out.println("Inside child frame");
	}
}
