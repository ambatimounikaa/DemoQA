package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;


public class Alerts {
	WebDriver dr;
	
	@FindBy(how=How.ID, using="alertButton")
	WebElement clickme1;
	
	@FindBy(how=How.ID, using="timerAlertButton")
	WebElement clickme2;
	
	@FindBy(how=How.ID, using="confirmButton")
	WebElement clickme3;
	
	@FindBy(how=How.ID, using = "confirmResult")
	WebElement confirm;
	
	@FindBy(how=How.ID, using="promtButton")
	WebElement clickme4;
	
	@FindBy(how=How.ID, using="promptResult")
	WebElement promptText;
	
	public Alerts(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}
	
	public void handleClickOne() {
		clickme1.click();
		Alert alert = dr.switchTo().alert();
		alert.accept();
	}
	
	public void handleClickTwo() throws InterruptedException {
		clickme2.click();
		WebDriverWait wait = new WebDriverWait(dr,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = dr.switchTo().alert();
		alert.accept();
	}
	public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor)dr;
        js.executeScript("window.scrollBy(0,300)");
    }
	public void handleClickThree() {
		
		clickme3.click();
		Alert alert = dr.switchTo().alert();
		alert.accept();
		Assert.assertEquals(confirm.getText(), "You selected Ok");
		
		clickme3.click();
		alert.dismiss();
		Assert.assertEquals(confirm.getText(), "You selected Cancel");
	}
	
	public void handleClickFour(String s) {
		clickme4.click();
		Alert alert= dr.switchTo().alert();
		alert.sendKeys(s);
		alert.accept();
		Assert.assertEquals(promptText.getText(), "You entered "+s);
	}
}
