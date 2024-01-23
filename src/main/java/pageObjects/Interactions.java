package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;


public class Interactions {
	WebDriver dr;
	
	By interactions = By.xpath("//div[@class='accordion']/div[5]/div/ul/li");
	By listOfSelectables = By.xpath("//ul[@id='verticalListContainer']/li");
	
	By listOfSortables = By.xpath("//div[@class='vertical-list-container mt-4']/div");
	
	By resizableElement = By.xpath("//span[1][@class='react-resizable-handle react-resizable-handle-se']");
	By dragElement = By.id("draggable");
	By dropElements = By.id("droppable");

	
	By acceptDrop = By.id("droppableExample-tab-accept");
	By acceptable = By.id("acceptable");
	
	By preventDrop = By.id("droppableExample-tab-preventPropogation");
	By dragBox = By.id("dragBox");
	By innerDrop = By.id("notGreedyInnerDropBox");
	
	
	By revertDrop = By.id("droppableExample-tab-revertable");
	By revertDrag = By.id("revertable");
	By nonRevertDrag = By.id("notRevertable");
	
	 
	
	public Interactions(WebDriver dr) {
		this.dr= dr;
	}
	
	//to scroll down the window
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor)dr;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	
	//To handle sortable under interactions
	public void sortable() throws InterruptedException {
		List<WebElement> s = dr.findElements(listOfSortables);
		WebElement one  = s.get(0);
		WebElement two = s.get(1);
		WebElement three = s.get(2);
		WebElement four = s.get(3);
		WebElement five = s.get(4);
		WebElement six = s.get(5);
		
		Actions a = new Actions(dr);
		Thread.sleep(3000);
		a.dragAndDrop(one, six).build().perform();
	}
	
	//To handle selectable under interactions
	public void selectable() {
		List<WebElement> li= dr.findElements(interactions);
		WebElement selectTab = li.get(1);
		selectTab.click();
		List<WebElement> li1 = dr.findElements(listOfSelectables);
		System.out.println(li1.size());
		for(WebElement item: li1) {
			item.click();
			System.out.println("Clicked");
			
		}
		
	}
	
	
	//To handle droppable under interactions
	public void droppable() throws InterruptedException {
		List<WebElement> li = dr.findElements(interactions);
		WebElement dropTab = li.get(3);
		dropTab.click();
		
		WebElement source = dr.findElement(dragElement);
		
		List<WebElement> d = dr.findElements(dropElements);
		WebElement target = d.get(0);
		
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)dr;
		js.executeScript("window.scrollBy(0,300)");
		
		Actions a = new Actions(dr);
		Thread.sleep(5000);
		a.dragAndDrop(source, target).build().perform();
		
	}
	
	public void droppable1() throws InterruptedException {
		//to handle Accept droppable
		dr.findElement(acceptDrop).click();
		
		WebElement source1 = dr.findElement(acceptable);
		
		List<WebElement> d = dr.findElements(dropElements);
		WebElement target1 = d.get(1);
		
		
		Actions a = new Actions(dr);
		Thread.sleep(5000);
		a.dragAndDrop(source1, target1).build().perform();
	}
	
	public void droppable2() throws InterruptedException {
		//to handle prevent propagation droppable
		dr.findElement(preventDrop).click();
		
		WebElement source2 = dr.findElement(dragBox);
		WebElement target2 = dr.findElement(innerDrop);
		
		Actions a = new Actions(dr);
		Thread.sleep(5000);
		a.dragAndDrop(source2, target2).build().perform();
	}
	
	public void droppable3() throws InterruptedException {
		//to handle revert draggable 
		dr.findElement(revertDrop).click();
		WebElement source3 = dr.findElement(revertDrag);
		
		List<WebElement> d = dr.findElements(dropElements);
		WebElement target3 = d.get(2);
		
		Actions a = new Actions(dr);
		Thread.sleep(5000);
		a.dragAndDrop(source3, target3).build().perform();
		WebElement source4 = dr.findElement(nonRevertDrag);
		Thread.sleep(5000);
		a.dragAndDrop(source4, target3).build().perform();
	}
	
	//To handle draggable under interactions
	public void draggable() {
		List<WebElement> li = dr.findElements(interactions);
		WebElement dragTab = li.get(4);
		dragTab.click();
	}

}
