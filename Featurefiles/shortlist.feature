@tag
Feature:review and shortlist candidate's Application

@Login
Scenario: Verify Recruiter Ai Login Functionality
Given Launch Application using valid URL
When User enters valid credentials "paul@trainingqa.com" and "XPAStag0"
Then verify captcha and click on Login button

@Shortlist
Scenario: verify recruiter able to shortlist received Applications
Given click on Total Applications available on dashboard
When Recruiter clicks on candidate's application