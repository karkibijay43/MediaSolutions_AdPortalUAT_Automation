@cucumberHooks
Feature: AdPortal UAT log in  

@AdPortalLogInDefault
Scenario: Log in with default user email and password

Given User is on AdPortal UAT sign up page and clicks Login link
When User enters username and password and clicks log in
Then User lands on request dashboard page

