@cucumberHooks
Feature: Reach intro page validation 

@ReachIntroPage
Scenario: User selects next button on reach intro page

Given User is logged into Ad Portal
When User is on the request dashBoard with drafts page
Then User starts or continues with campaign
Then USer should land on intro step of the reach page
Then User clicks on next button 
Then User should be taken to the Reach 1 of 3 page