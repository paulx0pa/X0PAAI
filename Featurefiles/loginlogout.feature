@tag
Feature:Login and Logout

@Login
Scenario: Verify Recruiter Ai Login Functionality
Given Launch Application using valid URL
When User enters valid credentials "paul@trainingqa.com" and "XPAStag0"
Then verify captcha and click on Login button

@Logout
Scenario: Verify Recruiter Ai Logout Functionality
Given Click on Logout Button