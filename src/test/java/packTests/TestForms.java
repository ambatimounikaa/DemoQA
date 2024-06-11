package packTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.*;

import pageObjects.Forms;

public class TestForms {
	
	WebDriver dr;
	Forms f;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		dr = new ChromeDriver();
		dr.get("https://demoqa.com/automation-practice-form");
		dr.manage().window().maximize();
	}
	
	@Test
	public void fillForm() {
		f = new Forms(dr);
		f.personDetails();
		f.scrollDown();
		f.radioButtonGender("Female");
		f.scrollDown();
		f.contactDetails();
		f.enterDob();
		
		f.scrollDown();
		//f.comboBoxSubjects("Maths", null, null);
		f.checkBoxHobbies();
		f.scrollDown();
		f.uploadFile("C:\\Users\\ambat\\OneDrive\\Pictures\\R.jpg");
		f.adressTextBox();
		
	}
	
	/*@AfterTest
	public void tearDown() {
		dr.close();
	}*/

}
