package pageObjects;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Windows {
	WebDriver dr;
	String baseURL;
	
	@FindBy(how=How.XPATH,using="//button[@id='tabButton']")
	WebElement tabButton;
	
	@FindBy(how=How.XPATH,using="//button[@id='windowButton']")
	WebElement windowButton;
	
	@FindBy(how=How.ID,using="sampleHeading")
	WebElement pageText;
	
	
	@FindBy(how=How.ID, using="messageWindowButton")
	WebElement messagedWindow;
	
	public Windows(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements( dr,this);
	}
	
	public void handleNewTab() {
		baseURL= dr.getWindowHandle();
		tabButton.click();
		
		Set<String> child_IDs = dr.getWindowHandles();
		for(String id: child_IDs) {
			if(!baseURL.equals(id)) {
				dr.switchTo().window(id);
				String e = pageText.getText();
				Assert.assertEquals(e, "This is a sample page");
				dr.close();
			}
		}
		dr.switchTo().window(baseURL);
	}
	
	public void handleNewWindow() {
		baseURL = dr.getWindowHandle();
		windowButton.click();
		Set<String> child_IDs = dr.getWindowHandles();
		for(String id: child_IDs) {
			if(!baseURL.equals(id)) {
				dr.switchTo().window(id);
				System.out.println(dr.getTitle());
				dr.close();
			}
		}
		dr.switchTo().window(baseURL);
	}
	
	//To scroll the current window
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor)dr;
        js.executeScript("window.scrollBy(0,300)");

	}
	
	public void handleMessagedWindow() {
		baseURL = dr.getWindowHandle();
		messagedWindow.click();
		Set<String> child_IDs = dr.getWindowHandles();
		for(String id: child_IDs) {
			if(!baseURL.equals(id)) {
				dr.switchTo().window(id);
				dr.close();
			}
		}
		dr.switchTo().window(baseURL);
		
	}

}
