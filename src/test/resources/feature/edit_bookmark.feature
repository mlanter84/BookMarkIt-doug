Feature: Edit a bookmark
	Users must be logged in to edit a bookmark
	The dashboard must contain at least 1 bookmark to be able to edit a bookmark

Scenario: User has an account, has a bookmark, and is able to edit a bookmark
	Given the user is logged in
	And the user’s dashboard contains at least 1 bookmark
	When the user clicks on the Edit button to edit the bookmark’s details
