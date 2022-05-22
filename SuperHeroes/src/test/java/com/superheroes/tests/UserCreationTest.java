package com.superheroes.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.superheroes.pages.ChooseBattleFieldPage;
import com.superheroes.pages.HomePage;
import com.superheroes.utils.BaseTest;

/*
 * This test is to create a new user.
 * @Parameters takes input from testng_usercreation.xml
 */

public class UserCreationTest extends BaseTest{
		
	@Test
	@Parameters({"userName", "password"})
	public void registerUser(String userName, String password) {
		HomePage homePage = new HomePage(driver, userName, password);
		homePage.Register();
		homePage.VerifyLogin();
		
		ChooseBattleFieldPage chooseBattleFieldPage = new ChooseBattleFieldPage(driver);
		String actualText = chooseBattleFieldPage.getLoggedInText();
		String expectedText = "Choose your battle field "+userName;
		assertEquals(actualText, expectedText);
		System.out.println(userName+ " is created.");
	}

}
