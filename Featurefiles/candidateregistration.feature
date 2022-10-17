@tag
Feature:Candidate choose Sign in and Apply

@Registration
Scenario Outline:Verify Candidate registration
Given Candidate click on job link
When Candidate click on apply button of Job
And candidate choose sign in option to apply
Given candidate click on register Link
When candidate enter first name "<firstname>"
And candidate enter last name "<lastname>"
And candidate enters email "<mail>"
And candidate enters password "<password>"
And candidate enters conformpassword "<conformpassword>"
And candidate accepts terms and conditions
And candidate enters submit button of registration

Examples:
|firstname|lastname|mail|password|conformpassword|
|Akshay   |Kumar   |akshay@0001.com  |akshay@0001 |akshay@0001     |
|Suresh   |tom     |suresh@0001.com  |suresh@0001 |suresh@0001     |