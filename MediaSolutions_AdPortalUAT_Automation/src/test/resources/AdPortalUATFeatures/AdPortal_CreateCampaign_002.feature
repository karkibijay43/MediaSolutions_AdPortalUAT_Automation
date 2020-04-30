@cucumberHooks
Feature: AdPortal UAT create campaign feature

@CreateCampaignUserInPut
Scenario: Create a campaign with user based input using valid AdPortal UAT log in email and password 

Given User is on AdPortal UAT signup page and clicks log in link
When User enters existing email and password and clicks log in
Then User should land on request dashboard page with campaign drafts
Then User should be able to get started or continue with campaign draft
Then User enters the desired address and selects the distance in miles and clicks next
Then User should be able to create a campaign for selected dates
Then User should be able to review their campaign details
Then User should be able to name campaign and upload commercial
Then User should be able to enter payment information and place an order