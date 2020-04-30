@cucumberHooks
Feature: AdPortal UAT new user FAQ link functionlaity

@FAQLink
Scenario: New User lands on dashboard and selects the FAQ links

Given I am a new SSU user to Ad Portal
When  I log in using newly signed up log in email and password 
Then  I should land on the AdPortal new dashboard
Then  I should see the FAQ links 
Then  When I select the links the links should open the relevant FAQ page in a new browser tab