package com.superheroes.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.superheroes.utils.BasePage;

public class LeaderBoardPage extends BasePage{
	
	static WebDriver driver=null;
	private WebDriverWait wait;
	private int waitTime = 30;
	
	private String userName = null;
	

	public LeaderBoardPage(WebDriver driver, String userName) {
		super.driver = driver;
		super.wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		this.userName=userName;
	}
	
	//Get score from leaderboard for a user
	public void getScore() {
		By LeaderBoard_Score = By.xpath("//td[contains(text(), '"+userName+"')]/following-sibling::td");
		String pointsScored = getTextFunction(LeaderBoard_Score);
		System.out.println(userName+" 's score : "+pointsScored);
	}

}
