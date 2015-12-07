# Revision History
# 11-28-2015 - Initial Draft - Matt

Feature: Search for a bookmark
	Users must be logged in to search for bookmarks
	The dashboard must contain at least 1 bookmark to perform the search
	
Scenario: User has an account, has a bookmark, and is able to search for a bookmark
	Given the user is logged in
	And the user’s dashboard contains at least 1 bookmark
	When the user searches for a bookmark
	Then the relevant bookmarks should be displayed on screen
