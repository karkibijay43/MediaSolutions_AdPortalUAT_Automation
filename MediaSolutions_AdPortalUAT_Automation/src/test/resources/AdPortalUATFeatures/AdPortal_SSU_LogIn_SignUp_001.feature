@cucumberHooks
Feature: SSO LogIn SignUP AdportalUAT

@SSULogIn
Scenario: Sign up with user email and password

Given User is on AdPortal UAT sign up page
When User enters First Name,Last Name,Business Name,Zip Code,Phone Number,Email and Password
Then User reads and agrees terms and conditions and clicks next step
Then User should be able to create log in credentials for AdPortal UAT