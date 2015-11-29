Feature: Testing the login functionality
	User must have an account to login

Scenario: User has an account and logs in
	Given I am on the home page
	When I click on the login button
	Then I should be sent to the login page
	When I enter my username and password
	And click sign in
	Then I should be on the dashboard page
	
Scenario: User does not have an account and attempts to log in
	Given I am on the home page
	When I click on the login button
	Then I should be sent to the login page
	When I enter my username and password
	And I do not have an account
	Then I should remain on the login page
	And I should be alerted the username is not valid
	And I should be prompted to register an account