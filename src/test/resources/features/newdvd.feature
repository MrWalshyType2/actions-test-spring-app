Feature: DVD store accepts new dvds

  As a user, when I add a new DVD to my store, then the DVD should be saved to the stores item list.

  Scenario: Add single dvd
	  Given the following new DVDs
	    | Title 		| Year 		| Actor 		| ID |
	    | test  		| 2002 		| Actor1  	| 1  |
	  When the new DVDs are added to the store
	  And then requested with a get method
	  Then the request should return the new dvds
