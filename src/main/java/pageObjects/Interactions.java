package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Interactions {
	WebDriver dr;
	
	By interactions = By.xpath("//div[@class='accordion']/div[5]/div/ul/li");
	
	By listOfSelectables = By.xpath("//ul[@id='verticalListContainer']/li");
	
	
	 
	
	public Interactions(WebDriver dr) {
		this.dr= dr;
	}
	
	//to scroll down the window
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor)dr;
		js.executeScript("window.scrollBy(0,400)");
	}
	
	
	//To handle sortable under interactions
	public void sortable() {

	}
	
	//To handle selectable under interactions
	public void selectable() {
		List<WebElement> li= dr.findElements(interactions);
		WebElement selectTab = li.get(1);
		JavascriptExecutor js = (JavascriptExecutor)dr;
		js.executeScript("argument[0].scrollIntoView(true);", selectTab);
		selectTab.click();
		List<WebElement> li1 = dr.findElements(listOfSelectables);
		System.out.println(li1.size());
		for(WebElement item: li1) {
			item.click();
			System.out.println("Clicked");
			
		}
		
	}
	
	//To handle resizable under interactions
	public void resizable() {
		//WebElement e = dr.findElement();
		//JavascriptExecutor js = (JavascriptExecutor)dr;
		//js.executeScript("argument[0].scrollIntoView();", e);
		//e.click();
	}
	
	//To handle droppable under interactions
	public void droppable() {
		//WebElement e = dr.findElement(dropTab);
		//JavascriptExecutor js = (JavascriptExecutor)dr;
		//js.executeScript("argument[0].scrollIntoView();", e);
		//e.click();
	}
	
	//To handle draggable under interactions
	public void draggable() {
		//WebElement e = dr.findElement(dragTab);
		//JavascriptExecutor js = (JavascriptExecutor)dr;
		//js.executeScript("argument[0].scrollIntoView();", e);
		//e.click();
	}

}
