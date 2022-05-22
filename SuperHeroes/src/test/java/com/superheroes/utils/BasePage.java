package com.superheroes.utils;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected static WebDriver driver=null;
	protected WebDriverWait wait;
	//private int waitTime = 30;
	
	public BasePage() {
		super();
	}
	
	//Method to Clicks an element
	public boolean clickFunction(By element) {
		boolean isClicked = true;
		
		try {
			this.wait.until(ExpectedConditions.elementToBeClickable(element));
			driver.findElement(element).click();
			
		}catch(Exception e) {
			isClicked = false;
		}
		return isClicked;
	}
	
	//Method to Enter values in an element
	public boolean sendKeysFunction(By element, String keysToSend) {
		boolean isClicked = true;
		
		try {
			this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			driver.findElement(element).sendKeys(keysToSend);
			
		}catch(Exception e) {
			isClicked = false;
		}
		return isClicked;
	}
	
	//Method to get text in an element
	public String getTextFunction(By element) {
		String getText=null;
		try {
			this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			getText = driver.findElement(element).getText();
			
		}catch(Exception e) {
		}
		
		return getText;	
	}
	
	//Method to check if an element is present
	public boolean checkElementPresent(By element) {
		boolean isClicked = true;	
		try {
			this.wait.until(ExpectedConditions.presenceOfElementLocated(element));
			
		}catch(Exception e) {
			isClicked = false;
		}
		return isClicked;
	}

}
