@cucumberHooks
Feature: New customer dashboard view feature

@DashBoardView
Scenario: Dashboard view and functionality from new customer

Given A new user is on AdPortal UAT sign up page
When User enters all required fields
Then User accepts license agreement and clicks next step
Then User should be able to see blank dashboard page with no campaigns
