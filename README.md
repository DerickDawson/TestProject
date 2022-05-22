# TestProject

Web Automation (Master branch)

Tests are located in src/test/java -> com.superheroes.tests. 

It’s a Maven project and dependent jars are listed in pom.xml. Saving this project to local and pulling it in Eclipse should create Maven Dependencies folder with all required jars.

I used Eclipse IDE and used Mac system.

1.	User Creation – can be run only from TestNG xml file.

Steps to run: Open testing_usercreation.xml -> Right click- > Run As -> TestNG Suite

To run it again, update parameters to next value, for example if first run was made with “thor 0100”, then update to “thor0101” before running again”

2.	Take the Bus Challenge

Steps to run: Open TakethebusChallengeTest.java -> Right click -> Run As -> TestNG Test

3.	Go to a public place

Steps to run: Open GoToAPublicPlaceTest.java -> Right click -> Run As -> TestNG Test

4.	Running all tests from TestNG xml file – This creates a new user, runs take the bus and go to a public place using the new user.

Steps to run: Open testing_Regression.xml -> Right click- > Run As -> TestNG Suite

To run it again, update parameters to next value, for example if first run was made with “thor 0200”, then update to “thor0201” before running again”
*************

API Automation (Supervillain branch)

Tests are located in src/test/java -> com.supervillain.tests. 

It’s a Maven project and dependent jars are listed in pom.xml. Saving this project to local and pulling it in Eclipse should create Maven Dependencies folder with all required jars.

I used Eclipse IDE and used Mac system.

Steps to run: 

Open Covid19TheGameVillain.java -> Right click -> Run As -> TestNG Test


To run it again, update below variables to next value and then run.
-	REGISTER_LOGIN_USER
-	NEW_UPDATE_USER

