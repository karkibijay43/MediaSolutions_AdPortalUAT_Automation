@cucumberHooks
Feature: AdPortal UAT create campaign feature

@CreateCampaignDefault
Scenario: Create a campaign using your valid UAT login email and password

Given User is on AdPortal UAT signup page and clicks log in
When User enters email and password and clicks log in
Then User should land on request dashboard page and be able to create a campaign
Then User should be able to get started with the campaign
Then User enters the address and selects the distance and clicks next
Then User should be able to schedule a campaign
Then User should be able to review campaign
Then User should be able to name their campaign and upload commercial 
Then User should be able to enter credit card information and place an order
