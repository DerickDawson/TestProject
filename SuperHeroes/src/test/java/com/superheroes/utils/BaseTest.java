package com.superheroes.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected static WebDriver driver =  null;
	private static String URL = "https://responsivefight.herokuapp.com";
	
	// Launches Chrome and opens webpage.
	@BeforeTest
	public void setUp() {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);	 
			
	}
	
	//Closes all web browser
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}

}
