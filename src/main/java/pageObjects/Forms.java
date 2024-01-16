package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Forms {
	WebDriver dr;
	
	By firstName = By.id("firstName");
	By lastName = By.id("lastName");
	By email = By.id("userEmail");
	
	By gender1 = By.xpath("//label[@for='gender-radio-1']");
	By gender2 = By.xpath("//label[@for='gender-radio-2']");
	By gender3 = By.xpath("//label[@for='gender-radio-3']");

	By mobile = By.id("userNumber");
	By dob = By.id("dateOfBirthInput");
	By monthDropdown = By.xpath("//div/select[@fdprocessedid=\"0mtdds\"]");
	By subjects = By.id("subjectsContainer");
	By subjectInput = By.xpath("//input[@id='subjectsInput']");
	By menu = By.xpath("//div/input[@aria-autocomplete='list']");
	
	By hobby1 = By.xpath("//label[@for='hobbies-checkbox-1']");
	By hobby2 = By.xpath("//label[@for='hobbies-checkbox-2']");
	By hobby3 = By.xpath("//label[@for='hobbies-checkbox-3']");
	
	By upload = By.id("uploadPicture");

	By currentAddress = By.id("currentAddress");
	
	
	
	
	public Forms(WebDriver dr) {
		this.dr=dr;
	}
	
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor)dr;
		js.executeScript("window.scrollBy(0,100)");
	}
	public void personDetails() {
		dr.findElement(firstName).sendKeys("Ambati");
		dr.findElement(lastName).sendKeys("Tony");
		dr.findElement(email).sendKeys("tony360@gmail.com");
	
	}
	public void enterDob() {
		dr.findElement(dob).click();
		Select s = new Select(dr.findElement(monthDropdown));
		s.selectByValue("9");
		
	}
	public void radioButtonGender(String s) {
		if("Male".equalsIgnoreCase(s)) {
			dr.findElement(gender1).click();
		}
		else if("Female".equalsIgnoreCase(s)) {
			dr.findElement(gender2).click();
		}
		else
			dr.findElement(gender3).click();
			
	}
	public void contactDetails() {
		dr.findElement(mobile).sendKeys("9876543210");
	}
	
	public void comboBoxSubjects(String s1,String s2,String s3) {
		dr.findElement(subjects).click();
		System.out.println("Clicked");
		dr.findElement(subjectInput).sendKeys(s1);
		dr.findElement(menu).click();
		
	}
	
	public void checkBoxHobbies() {
		WebElement h1 = dr.findElement(hobby2);
		h1.click();
		WebElement h2 = dr.findElement(hobby3);
		h2.click();
	}
	
	public void uploadFile(String path) {
		//file upload using sendKeys();
		dr.findElement(upload).sendKeys(path);
		
	}
	public void adressTextBox() {
		dr.findElement(currentAddress).sendKeys("Ongole");
	}
	
}
