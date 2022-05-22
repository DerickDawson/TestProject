package com.superheroes.tests;


import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.superheroes.pages.LeaderBoardPage;
import com.superheroes.pages.ChooseBattleFieldPage;
import com.superheroes.pages.GoToAPublicPlacePage;
import com.superheroes.pages.HomePage;
import com.superheroes.utils.BaseTest;

/*
 * This method is to take Go to a public place challenge
 * @Parameters takes value from testng_Regression and default values are in @Optional
 * Prints score in console
 */

public class GoToAPublicPlaceTest extends BaseTest{	
	
	@Test
	@Parameters({"userName", "password"})
	public void test(@Optional("thor0001") String userName, @Optional("thor0001") String password) {
		
		HomePage homePage = new HomePage(driver, userName, password);
		homePage.Login();
		
		ChooseBattleFieldPage chooseBattleFieldPage = new ChooseBattleFieldPage(driver);
		chooseBattleFieldPage.selectGoToAPublicPlace();
		
		GoToAPublicPlacePage goToPublicPlacePage = new GoToAPublicPlacePage(driver);
		goToPublicPlacePage.completeGoToAPublicPlaceChallenge();
		
		LeaderBoardPage leaderBoardPage = new LeaderBoardPage(driver, userName);
		leaderBoardPage.getScore();
		
	}

}
