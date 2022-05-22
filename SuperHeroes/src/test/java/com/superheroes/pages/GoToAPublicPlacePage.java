package com.superheroes.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.superheroes.utils.BasePage;

public class GoToAPublicPlacePage extends BasePage {
	
	static WebDriver driver=null;
	private WebDriverWait wait;
	private int waitTime = 30;
	String Question = null;
	
	private static By Restaurant_Start_Button = By.xpath("//button[@id='restaurant_timer_start']");
	private static By LargeGroupofPeople_Restaurant_Question = By.xpath("//p[contains(text(),'large group of people')]");
	private static By LargeGroupofPeople_Restaurant_Answer = By.xpath("//a[contains(text(),'Use your super hero sanitizer')]");
	
	private static By Try_The_Next_Battle = By.xpath("//button[contains(text(), 'Try the next battle')]");
	
	private static By PeopleAtBarReusingShotGlasses_Question = By.xpath("//p[contains(text(),'re-using shot glasses')]");
	private static By PeopleAtBarReusingShotGlasses_Answer = By.xpath("//a[contains(text(), 'Do not ignore')]");
	
	private static By CheckYourFinalScore_Button = By.xpath("//button[contains(text(),'Check your final score')]");
	
	
	
	public GoToAPublicPlacePage(WebDriver driver) {
		super.driver = driver;
		super.wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
	}
	
	// Navigates through go to a public place challenge
	public void completeGoToAPublicPlaceChallenge() {
		clickFunction(Restaurant_Start_Button);
		
		// to check which question is displayed and to choose respective answer
		boolean isPresent = checkElementPresent(LargeGroupofPeople_Restaurant_Question);
		
		if(isPresent=true) {
			clickFunction(LargeGroupofPeople_Restaurant_Answer);
		}else {
			clickFunction(PeopleAtBarReusingShotGlasses_Answer);
		}
		
		clickFunction(CheckYourFinalScore_Button);
		
		
	}

}
