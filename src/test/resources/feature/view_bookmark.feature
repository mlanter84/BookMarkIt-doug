# Revision History
# 11-28-2015 - Initial Draft - Matt

Feature: View a bookmark’s details
	Users must be logged in to view bookmark details
	The dashboard must contain at least 1 bookmark to be able to display bookmark details

Scenario: User has an account, has a bookmark, and is able to view a bookmark’s details
	Given the user is logged in
	And the user’s dashboard contains at least 1 bookmark
	When the user clicks on the Details button to view the bookmark’s details
	Then the details of the bookmark are displayed on screen
