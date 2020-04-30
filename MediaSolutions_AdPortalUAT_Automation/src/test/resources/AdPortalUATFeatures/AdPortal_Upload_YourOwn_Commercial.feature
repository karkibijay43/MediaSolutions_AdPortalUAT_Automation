@cucumberHooks
Feature: AdPortal UAT upload your own commercial feature

@UploadYourCommercial
Scenario: Upload your own commercial into AdPortal campaign

Given User is on SignUp page and clicks log in
When User logs in using email and password 
Then User should land request dashboard page with draft campaign
Then User should be able to continue with the campaign
Then User selects the address and distance and clicks next
Then User should be able to select the dates to schedule a campaign
Then User should be able to review the campaign details 
Then User should be able to upload their own commercial
Then User should be able to enter business information and place an order
