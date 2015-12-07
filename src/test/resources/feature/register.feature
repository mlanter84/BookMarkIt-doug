# Revision History
# 11-28-2015 - Initial Draft - Matt

Feature: Testing the register functionality
	First time users need to register for an account

Scenario: User does not have an account and attempts to register an account
	Given I am on the home page
	When I click on the register button
	Then I should be sent to the registration page
	When I enter my username and password
	And click create account
	Then my account should be created
	And I should be sent to the login page
	
Scenario: User already has an account and attempts to register an account
	Given I am on the home page
	When I click on the register button
	Then I should be sent to the registration page
	When I enter my username and password
	And click create account
	And my username is already taken
	Then I should be alerted my username is already taken
	And I should remain on the registration page
	And I should be prompted to select a new username