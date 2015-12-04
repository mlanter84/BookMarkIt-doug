Feature: Add a bookmark
	Users must be logged in to add bookmarks

Scenario: User has an account and is able to add a bookmark
	Given the user is logged in
	When the user clicks the Add button to create a new bookmark
	Then the bookmark should be added to the user's dashboard