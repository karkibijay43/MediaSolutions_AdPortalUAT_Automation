@cucumberHooks
Feature: AdPortal UAT login  feature

@AdPortalLogInUserInPut
Scenario: Log in with user based email and password

Given User is on AdPortal UAT sign up page and clicks Login
When User enters desired email and password and clicks log in button
Then User lands on request dashboard page to start a campaign
