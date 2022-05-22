package com.superheroes.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.superheroes.utils.BasePage;

public class TakeTheBusPage extends BasePage {
	
	static WebDriver driver=null;
	private WebDriverWait wait;
	private int waitTime = 30;
	
	private static By Bus_Start_Button = By.xpath("//button[@id='bus_timer_start']");
	private static By Travel_Buy_FoodandMedical = By.xpath("//a[contains(text(), 'Use your superheroes Mask')]");
	
	private static By CheckYourFinalScore_Button = By.xpath("//button[contains(text(),'Check your final score')]");
	
	
	public TakeTheBusPage(WebDriver driver) {
		super.driver = driver;
		super.wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
	}
	
	// Navigates through take the bus challenge
	public void completeTakeTheBusChallenge() {
		clickFunction(Bus_Start_Button);
		clickFunction(Travel_Buy_FoodandMedical);
		clickFunction(CheckYourFinalScore_Button);
		
	}



}
