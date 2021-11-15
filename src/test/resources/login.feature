Feature: Login to Altoro Mutual

@admincred
Scenario:
	Given I am on the login page
	And I have typed in the username and password
	When I click login
	Then I am signed into Altoro Mutual
	
	
@transferfundsfromsavings
Scenario:
	Given I am on the Transfer Funds Page
	And I transfer <value1> from savings account to my checking account
	When I click transfer money
	Then I have transfered money
	Examples:
	|value1|
	|$4|
	|$2147483647|
	
	
@transferfundsfromchecking
Scenario Outline:
	Given I am on the Transfer Funds Page
	And I tranfer <value1> from checking account to my savings account
	When I click transfer money 
	Then I have tranfered money
	Examples:
	|value1|
	|$198|
	|$2147483647|
	

	
	
@searcharticles
Scenario:
	Given I am on the Search Articles Page
	And I search Watchfire
	When I click Query
	Then I have found article
	
@cutomizesitelanguage
Scenario:
	Given I am on the Customize Site Page
	When I click <language>
	Then My customized Site Language is <Site Language>
	Examples:
	|language|Site Language|
	|English|English|
	|International|International|
	
	
	
	
@signedon
Scenario:
	Given I am signed into Altoro Mutual
	When I click logout
	Then I am signed out of Altoro Mutual
	

@failedcred
Scenario:
  Given I am on the login page
	And I have typed in invalid credentials
	When I click login 
	Then I receive error message
