Feature: Remove a bookmark
	Users must be logged in to remove bookmarks
	The dashboard must contain at least 1 bookmark to be able to remove a bookmark

Scenario: User has an account, has a bookmark, and is able to remove a bookmark
	Given the user is logged in
	And the user’s dashboard contains at least 1 bookmark
	When the user clicks on the Remove button to remove the bookmark
	Then the bookmark is removed from the user’s dashboard
