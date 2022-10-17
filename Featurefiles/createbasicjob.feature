@tag
Feature:Create new Job with Basic Information

@Login
Scenario: Verify Recruiter Ai Login Functionality
Given Launch Application using valid URL
When User enters valid credentials "paul@trainingqa.com" and "XPAStag0"
Then verify captcha and click on Login button

@CreateNewJob
Scenario:Verify create new job functionality with basic information
Given Recruiter clicks on Jobs Menu 
Then select create new job section
When click on Start button of form
And choose office location
And add Job Title
And select Job Status
And choose candidates from other countries
And enable rank and file job
And Select Country Location
And Select City location
And add skills
And add Qualification
And add job type
And select minimum experience
And select maximum experience
And choose Employment type
And add no of vacancies
And add Job Description
And add Job Requirements
And click on submit button of job