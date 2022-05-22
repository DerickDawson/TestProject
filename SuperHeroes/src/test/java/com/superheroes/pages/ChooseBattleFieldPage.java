package com.superheroes.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.superheroes.utils.BasePage;

public class ChooseBattleFieldPage extends BasePage{
	
	static WebDriver driver=null;
	private WebDriverWait wait;
	private int waitTime = 30;
	
	private static By AreYouGame_Button = By.xpath("//a[contains(text(), 'Are you game?')]");
	private static By TakeTheBus_Button = By.xpath("//a[contains(text(), 'Take the bus')]");
	private static By GoToAPublicPlace_Button = By.xpath("//a[contains(text(), 'Go to a public place')]");
	private static By GoToTheOffice_Button = By.xpath("//a[contains(text(), 'Go to the office')]");
	
	private static By Text_Username = By.xpath("//p[contains(text(), 'Choose your battle field ')]");
	
	
	public ChooseBattleFieldPage(WebDriver driver) {
		super.driver = driver;
		super.wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
	}
	
	// To select Take the Bus challenge
	public void selectTakeTheBus() {
		clickFunction(TakeTheBus_Button);
	}
	
	// To select Go to a public place challenge
	public void selectGoToAPublicPlace() {
		clickFunction(GoToAPublicPlace_Button);
	}
	
	// To get text on which user is logged in
	public String getLoggedInText() {
		String actualText = getTextFunction(Text_Username);
		return actualText;
	}



	
}
