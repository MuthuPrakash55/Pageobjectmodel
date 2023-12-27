Feature: creating google account

Background: common for all test
		Given user launch the "chrome" browser
		When user enters the url for the website
		Then the user navigate to the right application page
		
Scenario: google signup
			Given user enter the name of "vijay" in the first name field
			And user enter the surname of "prakash" in the field
			When user clicks the next button
			Then user navigate to the right page

