package com.superheroes.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.superheroes.utils.BasePage;

public class HomePage extends BasePage {
	
	static WebDriver driver=null;
	private WebDriverWait wait;
	private int waitTime = 30;
	
	private static By Register_Button = By.xpath("//a[contains(text(),'Register')]");
	private static By Register_UserName_Box = By.id("uname");
	private static By Register_Password_Box = By.id("pwd");
	private static By Register_RepeatPassword_Box = By.id("psw-repeat");
	private static By Sign_Up_Button = By.id("signupbtn");
	
	private static By Login_Button = By.xpath("//a[@id='login']");
	private static By userName_Box = By.xpath("//input[@id='worrior_username']");
	private static By password_Box = By.xpath("//input[@id='worrior_pwd']");
	private static By LoginWarrior_Button = By.xpath("//a[@id='warrior']");
	private static By StartYourJourney_Button = By.xpath("//a[@id='start']");
	
	String userName = null; 
	String password = null;
	
	public HomePage(WebDriver driver, String userName, String password ) {
		super.driver = driver;
		super.wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		this.userName=userName;
		this.password=password;
	}
	
	// New user registration flow
	public void Register() {
		clickFunction(Register_Button);
		sendKeysFunction(Register_UserName_Box, userName);
		sendKeysFunction(Register_Password_Box, password);
		sendKeysFunction(Register_RepeatPassword_Box, password);
		clickFunction(Sign_Up_Button);
		
	}
	
	// Login flow
	public void Login() {
		clickFunction(Login_Button);
		sendKeysFunction(userName_Box, userName);
		sendKeysFunction(password_Box, password);
		clickFunction(LoginWarrior_Button);
		clickFunction(StartYourJourney_Button);
	}
	
	// Verify login flow
	public void VerifyLogin() {
		sendKeysFunction(password_Box, password);
		clickFunction(LoginWarrior_Button);
		clickFunction(StartYourJourney_Button);
	}
	
	
}
