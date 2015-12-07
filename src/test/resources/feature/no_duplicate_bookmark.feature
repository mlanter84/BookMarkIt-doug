# Revision History
# 11-28-2015 - Initial Draft - Matt

Feature: Do not add a duplicate bookmark
	Users must be logged in to attempt to add bookmarks
	The dashboard must contain at least 1 bookmark
	If the bookmark is not already on the dashboard then the bookmark should be added
	If the bookmark is already on the dashboard, then inform the user a duplicate is present and do not add the bookmark

Scenario: User has an account, has a bookmark, and is able to add a unique bookmark
	Given the user is logged in
	And the user’s dashboard contains at least 1 bookmark
	And the user’s dashboard already contains the same bookmark
	When the user clicks the Add button to create a new bookmark
	Then a message should be displayed informing user of the duplication
	But the bookmark should not be added to the user's dashboard
