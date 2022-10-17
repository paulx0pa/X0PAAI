@tag
Feature:Shortlist received Applications

@Login
Scenario: Verify Recruiter Ai Login Functionality
Given Launch Application using valid URL
When User enters valid credentials "paul@trainingqa.com" and "XPAStag0"
Then verify captcha and click on Login button

@Shortlist
Scenario: verify recruiter able to shortlist received Applications
Given click on Total Applications available on dashboard
Then select an application from list of applications
And Shortlist the selected Application
And add additional email recipients
And click on Submit button to send email to candidate

@Talentpool
Scenario:verify recruiter able to add candidate to Talent pool
Given click on add to talent pool button after selecting candidate
#Then recruiter choose add to new bucket Option
#When recruiter names the new Bucket
Then Click on Submit Button of Talent pool

@EmailTemplate
Scenario: verify recruiter able to choose email template
Given click on Add Email Button after selecting Candidate
Then choose Email template to send to candidate
And click on Submit button of EmailTemplates

@KIV
Scenario:verify recruiter able to handle Keep in view for selected candidate
Given click on KIV after selecting candidate from Applicants list
Then choose as required by using toggle and submit
 

@DownloadCV
Scenario: verify recruiter able to download cv of selected Application
Given click on download option to download cv of selected candidate
Then click on submit to download cv