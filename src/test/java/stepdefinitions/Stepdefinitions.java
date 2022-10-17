package stepdefinitions;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefinitions {
	public static WebDriver driver;
	@Given("^Launch Application using valid URL$")
	public void launch_Application_using_valid_URL() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("disable-gpu");
		driver=new ChromeDriver(options);
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//driver = new ChromeDriver();
        //driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://staging.x0pa.ai/app/roboroy");  
        driver.findElement(By.id("hs-eu-confirmation-button")).click();
        driver.findElement(By.linkText("Candidate Login")).click();      
	}

	@When("^User enters valid credentials \"(.*)\" and \"(.*)\"$")
	public void user_enters_valid_credentials(String email,String password) throws Throwable {
		driver.findElement(By.name("username")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password); 
	}
	@Then("^verify captcha and click on Login button$")
	public void verify_captcha_and_click_on_Login_button() throws Throwable {
		driver.findElement(By.xpath("//div[@class='mb-2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		Thread.sleep(3000);
	}
	@Given("^Click on Logout Button$")
	public void click_on_Logout_Button() throws Throwable {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@aria-label='Logout']")).click();
		Thread.sleep(4000);  
	}

	
	@Given("^Close Browser$")
	public void close_Browser() throws Throwable {
	    driver.close();
	}
	
@Given("^Recruiter clicks on Jobs Menu$")
public void recruiter_clicks_on_Jobs_Menu() throws Throwable {
	Thread.sleep(3000);	
	driver.findElement(By.xpath("/html/body/section/div[1]/div/header/nav/ul/li[2]/a")).click();   
}
	
	@Then("^select create new job section$")
	public void select_create_new_job_section() throws Throwable {
	   
	
	 driver.findElement(By.linkText("Create New Job")).click();
	 Thread.sleep(2000); 
	}

@When("^click on Start button of form$")
public void click_on_Start_button_of_form() throws Throwable {
	driver.findElement(By.xpath("//div[@class='mt-3']//child::button[contains(text(),'Start')]")).click(); 
	Thread.sleep(4000);
}

@When("^click on Add New Office button to add new office Address$")
public void click_on_Add_New_Office_button_to_add_new_office_Address() throws Throwable {
	    WebElement addnewoffice=driver.findElement(By.xpath("//button[contains(text(),'Add New office')]"));
	    addnewoffice.click();
	    Thread.sleep(2000);
		driver.findElement(By.id("addressLine1")).sendKeys("peaceful city");
		WebElement city=driver.findElement(By.id("react-select-13-input"));
		Thread.sleep(2000);
		city.sendKeys("Hyderabad");
		Thread.sleep(2000);
		city.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		city.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Select country=new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("India");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
	
}

@When("^add Job Title$")
public void add_Job_Title() throws Throwable {
	WebElement jobtitle=driver.findElement(By.xpath("//input[@placeholder='Job Title']"));
	jobtitle.sendKeys("Java Developers");
	Thread.sleep(2000);  
}

@When("^select Job Status$")
public void select_Job_Status() throws Throwable {
	WebElement jobstatus=driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
	jobstatus.sendKeys("Both");
	jobstatus.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	jobstatus.sendKeys(Keys.ENTER);
	Thread.sleep(2000); 
}

@When("^Select Country Location$")
public void select_Country_Location() throws Throwable {
	WebElement countrylocation=driver.findElement(By.xpath("//input[@id='react-select-5-input']"));
	countrylocation.sendKeys("india");
	countrylocation.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	countrylocation.sendKeys(Keys.ENTER);
	Thread.sleep(2000);  
}

@When("^Select City location$")
public void select_City_location() throws Throwable {
	WebElement citylocation=driver.findElement(By.id("react-select-6-input"));
	citylocation.sendKeys("Hyderabad");
	citylocation.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(5000);
	citylocation.sendKeys(Keys.ENTER);
	Thread.sleep(3000);  
}

@When("^add skills$")
public void add_skills() throws Throwable {
	WebElement skills=driver.findElement(By.id("react-select-7-input"));
	skills.sendKeys("java");
	skills.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	skills.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	skills.sendKeys("sql");
	skills.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	skills.sendKeys(Keys.ENTER);
	Thread.sleep(4000);
}

@When("^add Qualification$")
public void add_Qualification() throws Throwable {
	 WebElement qualification=driver.findElement(By.xpath("//input[@id='react-select-8-input']"));
     qualification.sendKeys("b");
     qualification.sendKeys(Keys.ARROW_DOWN);
     Thread.sleep(2000);
     qualification.sendKeys(Keys.ENTER);
     Thread.sleep(2000);   
}

@When("^add job type$")
public void add_job_type() throws Throwable {
	WebElement jobtype=driver.findElement(By.xpath("//input[@id='react-select-9-input']"));
	jobtype.sendKeys("per");
    jobtype.sendKeys(Keys.ARROW_DOWN);
    Thread.sleep(2000);
    jobtype.sendKeys(Keys.ENTER);
    Thread.sleep(2000);  
}

@When("^select minimum experience$")
public void select_minimum_experience() throws Throwable {
	driver.findElement(By.xpath("//input[@id='minExp']")).sendKeys("3");;
	Thread.sleep(2000); 
}

@When("^select maximum experience$")
public void select_maximum_experience() throws Throwable {
	driver.findElement(By.id("maxExp")).sendKeys("5");
	Thread.sleep(2000);  
}

@When("^choose Employment type$")
public void choose_Employment_type() throws Throwable {
	WebElement emptype=driver.findElement(By.xpath("//input[@id='react-select-10-input']"));
	emptype.sendKeys("full time");
	emptype.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	emptype.sendKeys(Keys.ENTER);
	Thread.sleep(2000);   
}

@When("^add no of vacancies$")
public void add_no_of_vacancies() throws Throwable {
	WebElement vacancies=driver.findElement(By.xpath("//input[@id='noOfVacancies']"));
	vacancies.click();
	Thread.sleep(2000);
	vacancies.sendKeys("15");
	Thread.sleep(2000);  
}

@When("^add Job Description$")
public void add_Job_Description() throws Throwable {
	driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")).sendKeys("writing test cases,Exploratory Testing,Automation Testing");
	Thread.sleep(2000);  
}

@When("^add Job Requirements$")
public void add_Job_Requirements() throws Throwable {
	driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("candidates should join immediately & candidates should have knowledge on selenium and core java");
	Thread.sleep(2000);  
   
}

@When("^choose office location$")
public void choose_office_location() throws Throwable {
	 WebElement OfficeAddress=driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
	    OfficeAddress.sendKeys("Hyderabad");
	    Thread.sleep(2000);
		OfficeAddress.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		OfficeAddress.sendKeys(Keys.ENTER);
		Thread.sleep(3000);  
		  
}
@When("^add date of join$")
public void add_date_of_join() throws Throwable {
	 WebElement doj=driver.findElement(By.xpath("(//input[@name='closeDate'])[2]"));
	 doj.sendKeys("2022-10-22");
	 doj.sendKeys(Keys.ENTER);
	 Thread.sleep(2000);
}

@Given("^click on submit button of job$")
public void click_on_submit_button_of_job() throws Throwable {
	//NF primary recruiter
	WebElement prrec=driver.findElement(By.id("react-select-12-input"));
	prrec.sendKeys("Anand");
    Thread.sleep(2000);
	prrec.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(3000);
	prrec.sendKeys(Keys.ENTER);
	Thread.sleep(4000);
   driver.findElement(By.xpath("//div[@class='ml-2']//child::button[contains(text(),'Submit')]")).click();    
}
@Given("^add skills and Education$")
public void add_skills_and_Education() throws Throwable {
  

	 driver.findElement(By.xpath("(//li[@class='sui-single-option-facet__item inactive'])[1]")).click();
}

@When("^add industry field$")
public void add_industry_field() throws Throwable {
	WebElement industry=driver.findElement(By.xpath("//input[@id='react-select-13-input']"));
    industry.sendKeys("Computer Software");
    Thread.sleep(2000);
	industry.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	industry.sendKeys(Keys.ENTER);
	Thread.sleep(2000);   
}

@When("^add keyword field$")
public void add_keyword_field() throws Throwable {
	WebElement keyword =driver.findElement(By.xpath("//input[@id='react-select-14-input']"));
    keyword.sendKeys("java");
	keyword.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	keyword.sendKeys(Keys.ENTER);
	Thread.sleep(2000);   
}

@When("^add Education$")
public void add_Education() throws Throwable {
   

	WebElement education=driver.findElement(By.xpath("//input[@id='react-select-15-input']"));
	education.sendKeys("bsc");
	education.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	education.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@class='sui-single-option-facet__link active']")).click(); 
}

@Given("^click on Additional Information$")
public void click_on_Additional_Information() throws Throwable {
   

	 driver.findElement(By.xpath("/html/body/section/div[1]/div/div[3]/div/section/div/div/div[2]/div[3]/div[2]/div/div[1]/div/div/div/div/ul/li[3]/a")).click();  
}

@When("^add Work Location$")
public void add_Work_Location() throws Throwable {
	driver.findElement(By.xpath("//textarea[@id='workLocation']")).sendKeys("Hyderabad");  
}

@Then("^add working Hours$")
public void add_working_Hours() throws Throwable {
	 driver.findElement(By.xpath("//textarea[@name='workHours']")).sendKeys("8hrs");  
}

@Then("^enter minimal Annual Salary$")
public void enter_minimal_Annual_Salary() throws Throwable {
	  driver.findElement(By.xpath("//input[@id='minSalary']")).sendKeys("30,000");  
}

@Then("^enter maximum Annual Salary$")
public void enter_maximum_Annual_Salary() throws Throwable {
	driver.findElement(By.xpath("//input[@id='maxSalary']")).sendKeys("1,00,000");   
}


@Given("^add pre screening questions$")
public void add_pre_screening_questions() throws Throwable {
   


	driver.findElement(By.xpath("/html/body/section/div[1]/div/div[3]/div/section/div/div/div[2]/div[3]/div[2]/div/div[1]/div/div/div/div/ul/li[4]/a")).click();
	} 


@When("^click on Add Question button$")
public void click_on_Add_Question_button() throws Throwable {
	Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[contains(text(),'Select Questions')]")).click();  
}

@When("^enter Question$")
public void enter_Question() throws Throwable {
	Thread.sleep(2000);
	 driver.findElement(By.xpath("(//button[contains(text(),'Add')])[1]")).click();
	   driver.findElement(By.xpath("//textarea[@name='question']")).sendKeys("done any course?");
}

@When("^choose the Category of Question$")
public void choose_the_Category_of_Question() throws Throwable {
	WebElement category=driver.findElement(By.xpath("//input[@id='react-select-17-input']"));
	   category.sendKeys("hr");
	   Thread.sleep(2000);
	   category.sendKeys(Keys.ARROW_DOWN);
	   Thread.sleep(2000);
	   category.sendKeys(Keys.ENTER);
	   Thread.sleep(2000); 
}
@Then("^click on Submit Button$")
public void click_on_Submit_Button() throws Throwable {
   

   driver.findElement(By.xpath("(//button[contains(text(),'Submit')])[1]")).click();
	   Thread.sleep(2000);
}
@When("^Select questions from displayed List$")
public void select_questions_from_displayed_List() throws Throwable {
	Thread.sleep(3000);
  driver.findElement(By.xpath("/html/body/section/div[1]/div/div[3]/div/section/div/div/div[2]/div[3]/div[2]/div/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div/table/thead/tr/th[1]/label")).click();
}

@When("^click on Add Selected option$")
public void click_on_Add_Selected_option() throws Throwable {
	driver.findElement(By.xpath("(//button[@class='bx--btn bx--btn--primary'])[2]")).click(); 
}


@Then("^Select questions from Questions List$")
public void select_questions_from_Questions_List() throws Throwable {
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("/html/body/section/div[1]/div/div[3]/div/section/div/div/div[4]/div[2]/div[2]/div[2]/div/table/tbody/tr[2]/td/div[3]/div/div[2]/div/div[4]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div/table/thead/tr/th[1]/label")).click();
	 
}


@Then("^click on Add Selected$")
public void click_on_Add_Selected() throws Throwable {
       Thread.sleep(2000);
	   driver.findElement(By.xpath("//button[contains(text(),'Add Selected')]")).click();		
	   Thread.sleep(2000); 
}
@Given("^Click on Attachments section$")
public void click_on_Attachments_section() throws Throwable {
   driver.findElement(By.xpath("/html/body/section/div[1]/div/div[3]/div/section/div/div/div[2]/div[3]/div[2]/div/div[1]/div/div/div/div/ul/li[5]/a")).click();
   driver.findElement(By.xpath("//div[@class='bx--file__drop-container']")).click();

}
@When("^choose candidates from other countries$")
public void choose_candidates_from_other_countries() throws Throwable {
	Thread.sleep(2000);
  driver.findElement(By.xpath("(//span[@class='bx--toggle__switch'])[3]")).click();
}

@When("^enable rank and file job$")
public void enable_rank_and_file_job() throws Throwable {
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//span[@class='bx--toggle__switch'])[4]")).click(); 
}

@When("^enable if job requires approvals$")
public void enable_if_job_requires_approvals() throws Throwable {
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//span[@class='bx--toggle__switch'])[5]")).click(); 
}
@When("^add choose Approval for$")
public void add_choose_Approval_for() throws Throwable {
	WebElement approvalfor=driver.findElement(By.xpath("//input[@id='react-select-13-input']"));
	Thread.sleep(2000);
	approvalfor.sendKeys("kishore");
	approvalfor.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	approvalfor.sendKeys(Keys.ENTER);
    Thread.sleep(2000); 
}
@Given("^Enable collaborator control$")
public void enable_collaborator_control() throws Throwable {
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id='app-container']/div[1]/div/div[3]/div/section/div/div/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/label/span")).click();
}
@Given("^user clicks on Add Collaborator option$")
public void user_clicks_on_Add_Collaborator_option() throws Throwable {
	driver.findElement(By.xpath("(//button[contains(text(),'Add Collaborator')])[2]")).click(); 
	Thread.sleep(2000);
	Select Collabrole=new Select(driver.findElement(By.xpath("//select[@name='selectedRoleId']")));
	Collabrole.selectByVisibleText("Team Member");
	Thread.sleep(2000);
	WebElement collaborator=driver.findElement(By.xpath("//div[contains(text(),'Select User')]"));
	collaborator.sendKeys("Sai Charan");
	Thread.sleep(2000);
	collaborator.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	collaborator.sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//button[contains(text(),'Add')])[3]")).click(); 
}

@Given("^enable prescreening settings$")
public void enable_prescreening_settings() throws Throwable {
	Thread.sleep(3000);
   driver.findElement(By.xpath("(//span[@class='bx--toggle__switch'])[2]")).click();
   }
@When("^ask pre screening questions via chatbot$")
public void ask_pre_screening_questions_via_chatbot() throws Throwable {
	Thread.sleep(3000);
 driver.findElement(By.xpath("(//span[@class='bx--toggle__switch'])[3]")).click();  
}

@When("^enable submit only if candidate answers knockout Questions$")
public void enable_submit_only_if_candidate_answers_knockout_Questions() throws Throwable {
	Thread.sleep(3000);
	 driver.findElement(By.xpath("(//span[@class='bx--toggle__switch'])[4]")).click();  
}

@When("^save pre screening Settings$")
public void save_pre_screening_Settings() throws Throwable {
	Thread.sleep(3000);
	 driver.findElement(By.xpath("(//button[@class='bx--btn bx--btn--primary'])[5]")).click();  
}
@Given("^user Enables Autoshortlist button$")
public void user_Enables_Autoshortlist_button() throws Throwable {
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='bx--toggle__switch'])[5]")).click(); 
}
@When("^user gives passing points$")
public void user_gives_passing_points() throws Throwable {
   driver.findElement(By.xpath("//input[@id='passingPoints']")).sendKeys("0");
}


@Then("^Save Autoshortlist settings$")
public void save_Autoshortlist_settings() throws Throwable {
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//button[@class='bx--btn bx--btn--primary'])[6]")).click();  
}

@Given("^user enable interview setup button$")
public void user_enable_interview_setup_button() throws Throwable {
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[@class='bx--toggle__switch'])[6]")).click();  
}

@When("^user click on add interview stage$")
public void user_click_on_add_interview_stage() throws Throwable {
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//button[@class='bx--btn bx--btn--primary'])[7]")).click(); 
}
@When("^Choose interview Stage$")
public void choose_interview_Stage() throws Throwable {
 Thread.sleep(2000);
 driver.findElement(By.xpath("(//span[@class='bx--radio-button__appearance'])[3]")).click();  
}

@When("^choose interview type$")
public void choose_interview_type() throws Throwable {
  Select interviewtype=new Select(driver.findElement(By.xpath("//select[@id='workflowStage']"))); 
  interviewtype.selectByVisibleText("Phone Interview");
  Thread.sleep(2000);
}

@When("^submit interview setup$")
public void submit_interview_setup() throws Throwable {
	driver.findElement(By.xpath("(//button[@class='bx--btn bx--btn--primary'])[9]")).click();
	Thread.sleep(4000);
}
@When("^upload Attachment file$")
public void upload_Attachment_file() throws Throwable {
	
	Thread.sleep(2000);
	Robot rb = new Robot();
	 
    StringSelection str = new StringSelection("~/xuploads/jd.docx");
    Thread.sleep(2000);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
     rb.keyPress(KeyEvent.VK_CONTROL);
     rb.keyPress(KeyEvent.VK_V);
     rb.keyRelease(KeyEvent.VK_CONTROL);
     rb.keyRelease(KeyEvent.VK_V);
     rb.keyPress(KeyEvent.VK_ENTER);
     rb.keyRelease(KeyEvent.VK_ENTER);
}
@When("^click on submit after uploading file$")
public void click_on_submit_after_uploading_file() throws Throwable {
 Thread.sleep(2000);
 driver.findElement(By.xpath("(//button[@class='bx--btn bx--btn--primary'])[1]")).click();
 Thread.sleep(3000);
}
@Given("^Candidate click on job link$")
public void candidate_click_on_job_link() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.get("https://staging.x0pa.ai/app/roboroy/job/607164?sharing=6c12f734e5d295f22b21be"); 
}

@When("^Candidate click on apply button of Job$")
public void candidate_click_on_apply_button_of_Job() throws Throwable {
	    driver.findElement(By.xpath("//a[@id='hs-eu-confirmation-button']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[contains(text(),'Apply Now')]")).click();
}

@When("^candidate choose to apply as guest$")
public void candidate_choose_to_apply_as_guest() throws Throwable {
 driver.findElement(By.xpath("(//span[@class='bx--radio-button__appearance'])[1]")).click();
}
@When("^Candidate enters his first name$")
public void candidate_enters_his_first_name() throws Throwable {
	 driver.findElement(By.xpath("//input[@id='candidateFirstName']")).sendKeys("Vinay");   
}

@When("^Candidate enters his last name$")
public void candidate_enters_his_last_name() throws Throwable {
	 WebElement lastname=driver.findElement(By.xpath("//input[@id='candidateLastName']"));
	 lastname.sendKeys("Bhargav"); 
}

@When("^Candidate  choose Country$")
public void candidate_choose_Country() throws Throwable {
	Select country=new Select(driver.findElement(By.xpath("//select[@class='bx--select-input']")));
	country.selectByValue("105");  
}

@When("^Candidate enters Mobile number$")
public void candidate_enters_Mobile_number() throws Throwable {
	driver.findElement(By.id("candidatePhoneNumber")).sendKeys("8333939637");  
}

@When("^Candidate enters his Email Address$")
public void candidate_enters_his_Email_Address() throws Throwable {
	driver.findElement(By.id("candidateEmail")).sendKeys("paul109637@gmail.com"); 
}

@When("^Candidate uploads his resume$")
public void candidate_uploads_his_resume() throws Throwable {
	Thread.sleep(2000);
	driver.findElement(By.className("bx--file__drop-container")).click();
	Robot rb = new Robot();
	 StringSelection str = new StringSelection("~/xuploads/VinayResume.docx");
	 Thread.sleep(2000);
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	 rb.keyPress(KeyEvent.VK_CONTROL);
	 rb.keyPress(KeyEvent.VK_V);
	 rb.keyRelease(KeyEvent.VK_CONTROL);
	 rb.keyRelease(KeyEvent.VK_V);
	 rb.keyPress(KeyEvent.VK_ENTER);
	 rb.keyRelease(KeyEvent.VK_ENTER);   
}

@Then("^Candidate accepts terms and conditions by clicking on checkbox$")
public void candidate_accepts_terms_and_conditions_by_clicking_on_checkbox() throws Throwable {
	String script = "return window.getComputedStyle(document.querySelector('#bx--checkbox-label'),':before')";
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click(); ", script);

}

@Then("^clicks on Next Button$")
public void clicks_on_Next_Button() throws Throwable {
	driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
}

@When("^candidate mentions about him in about me text field$")
public void candidate_mentions_about_him_in_about_me_text_field() throws Throwable {
	driver.findElement(By.xpath("(//textarea[@id='summary'])[1]")).sendKeys("My name is Vinay.Icompleted my graduation in xyz university & trained on testing tools");   
}

@Then("^candidate clicks on add button of project$")
public void candidate_clicks_on_add_button_of_project() throws Throwable {
	driver.findElement(By.xpath("//a[@id='addProject']")).click(); 
}


@When("^candidate enters project title$")
public void candidate_enters_project_title() throws Throwable {
	driver.findElement(By.xpath("//input[@id='project']")).sendKeys("ERP-Stock Accounting"); 
}

@When("^candidate enters Description of project$")
public void candidate_enters_Description_of_project() throws Throwable {
	driver.findElement(By.xpath("(//textarea[@id='summary'])[2]")).sendKeys("This project belongs to ERP,contains different modules .I worked on sales and purchases modules");  
}

@When("^Candidate selects project start and end dates$")
public void candidate_selects_project_start_and_end_dates() throws Throwable {
	driver.findElement(By.xpath("//input[@placeholder='Start Date']")).sendKeys("20 june 2021");
	driver.findElement(By.xpath("//input[@placeholder='End Date']")).sendKeys("20 December 2021"); 
}

@When("^Click on Save button of project$")
public void click_on_Save_button_of_project() throws Throwable {
	driver.findElement(By.xpath("//button[text()='Save']")).click();
}

@When("^Candidate click on next Button$")
public void candidate_click_on_next_Button() throws Throwable {
	driver.findElement(By.xpath("//button[text()='Next']")).click();
}
	@When("^Candidate clicks on edit option of EducationA$")
	public void candidate_clicks_on_edit_option_of_EducationA() throws Throwable {
		driver.findElement(By.xpath("//a[@id='editEdu-1']")).click(); 
	}

	@When("^enters InstituteA Name$")
	public void enters_InstituteA_Name() throws Throwable {
		driver.findElement(By.xpath("(//input[@id='institution'])[1]")).sendKeys("Sri YN College");
	}

	@When("^choose country of instituteA$")
	public void choose_country_of_instituteA() throws Throwable {
		Select Country=new Select(driver.findElement(By.xpath("(//select[@class='bx--select-input'])[1]")));
		Country.selectByValue("India");  
	}

	@When("^choose city of instituteA$")
	public void choose_city_of_instituteA() throws Throwable {
		driver.findElement(By.xpath("(//input[@placeholder='Enter City'])[1]")).sendKeys("Narsapur"); 
	}

	@When("^select Qualification from InstituteA$")
	public void select_Qualification_from_InstituteA() throws Throwable {
		Select Edulevel=new Select(driver.findElement(By.xpath("(//select[@class='bx--select-input'])[2]")));
		Edulevel.selectByVisibleText("Bachelor's Degree");
	}

	@When("^Enter CGPA got in InstituteA$")
	public void enter_CGPA_got_in_InstituteA() throws Throwable {
		driver.findElement(By.xpath("(//input[@id='gpa'])[1]")).sendKeys("8.0");   
	}

	@When("^choose start date of InstituteA$")
	public void choose_start_date_of_InstituteA() throws Throwable {
		driver.findElement(By.xpath("(//input[@placeholder='Start Date'])[1]")).sendKeys("12th june,2017");  
	}

	@When("^choose ending date of InstitueA$")
	public void choose_ending_date_of_InstitueA() throws Throwable {
		driver.findElement(By.xpath("(//input[@placeholder='End Date'])[1]")).sendKeys("30 April,2021");   
	}

	@When("^Click on Save Button of EduA$")
	public void click_on_Save_Button_of_EduA() throws Throwable {
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();   
	}
	@When("^Candidate clicks on edit option of EducationB$")
	public void candidate_clicks_on_edit_option_of_EducationB() throws Throwable {
		driver.findElement(By.xpath("//a[@id='editEdu-2']")).click();
	}

	@When("^enters InstituteB Name$")
	public void enters_InstituteB_Name() throws Throwable {
		driver.findElement(By.xpath("(//input[@id='institution'])[2]")).sendKeys("Vikas Junior College");
	}

	@When("^choose country of instituteB$")
	public void choose_country_of_instituteB() throws Throwable {
		Select CountryC2=new Select(driver.findElement(By.xpath("(//select[@class='bx--select-input'])[4]")));
		CountryC2.selectByValue("India");
	}

	@When("^choose city of instituteB$")
	public void choose_city_of_instituteB() throws Throwable {
		driver.findElement(By.xpath("(//input[@placeholder='Enter City'])[2]")).sendKeys("Malikipuram"); 
	}

	@When("^select Qualification from InstituteB$")
	public void select_Qualification_from_InstituteB() throws Throwable {
		Select EdulevelE2=new Select(driver.findElement(By.xpath("(//select[@class='bx--select-input'])[5]")));
		EdulevelE2.selectByVisibleText("Diploma");
	}

	@When("^Enter CGPA got in InstituteB$")
	public void enter_CGPA_got_in_InstituteB() throws Throwable {
		driver.findElement(By.xpath("(//input[@id='gpa'])[2]")).sendKeys("8.0");
	}

	@When("^choose start date of InstituteB$")
	public void choose_start_date_of_InstituteB() throws Throwable {
		driver.findElement(By.xpath("(//input[@placeholder='Start Date'])[2]")).sendKeys("12th june,2015");
	}

	@When("^choose ending date of InstitueB$")
	public void choose_ending_date_of_InstitueB() throws Throwable {
		driver.findElement(By.xpath("(//input[@placeholder='End Date'])[2]")).sendKeys("30 April,2017");  
	}

	@When("^Click on Save Button of EduB$")
	public void click_on_Save_Button_of_EduB() throws Throwable {
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click(); 
	}
	
	@When("^Candidate clicks on edit option of EducationC$")
	public void candidate_clicks_on_edit_option_of_EducationC() throws Throwable {
		driver.findElement(By.xpath("//a[@id='editEdu-3']")).click();
	}

	@When("^enters InstituteC Name$")
	public void enters_InstituteC_Name() throws Throwable {
		driver.findElement(By.xpath("(//input[@id='institution'])[3]")).sendKeys("Vivekananda Public School"); 
	}

	@When("^choose country of instituteC$")
	public void choose_country_of_instituteC() throws Throwable {
		Select CountryC3=new Select(driver.findElement(By.xpath("(//select[@class='bx--select-input'])[7]")));
		CountryC3.selectByValue("India");
	}

	@When("^choose city of instituteC$")
	public void choose_city_of_instituteC() throws Throwable {
		driver.findElement(By.xpath("(//input[@placeholder='Enter City'])[3]")).sendKeys("Malikipuram");
	}

	@When("^select Qualification from InstituteC$")
	public void select_Qualification_from_InstituteC() throws Throwable {
		Select EdulevelE3=new Select(driver.findElement(By.xpath("(//select[@class='bx--select-input'])[8]")));
		EdulevelE3.selectByVisibleText("High School or Equivalent");
	}

	@When("^Enter CGPA got in InstituteC$")
	public void enter_CGPA_got_in_InstituteC() throws Throwable {
		driver.findElement(By.xpath("(//input[@id='gpa'])[3]")).sendKeys("8.0"); 
	}

	@When("^choose start date of InstituteC$")
	public void choose_start_date_of_InstituteC() throws Throwable {
		driver.findElement(By.xpath("(//input[@placeholder='Start Date'])[3]")).sendKeys("12th june,2014"); 
	}

	@When("^choose ending date of InstitueC$")
	public void choose_ending_date_of_InstitueC() throws Throwable {
		driver.findElement(By.xpath("(//input[@placeholder='End Date'])[3]")).sendKeys("30 April,2015");   
	}

	@When("^Click on Save Button of EduC$")
	public void click_on_Save_Button_of_EduC() throws Throwable {
		driver.findElement(By.xpath("(//button[text()='Save'])[3]")).click();  
	}
	@When("^candidate rate for skills$")
	public void candidate_rate_for_skills() throws Throwable {
		driver.findElement(By.xpath("java_5")).click();
		driver.findElement(By.xpath("//label[@for='microsoft sql server_4']")).click(); 
	}

	@When("^candidate click on submit button of Application$")
	public void candidate_click_on_submit_button_of_Application() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	@When("^candidate choose sign in option to apply$")
	public void candidate_choose_sign_in_option_to_apply() throws Throwable {
		 driver.findElement(By.xpath("(//span[@class='bx--radio-button__appearance'])[2]")).click();
	}

	@Given("^candidate click on register Link$")
	public void candidate_click_on_register_Link() throws Throwable {
	driver.findElement(By.xpath("//a[text()='Register']")).click();
	}
	@When("^candidate enter first name \"(.*)\"$")
	public void candidate_enter_first_name(String fname) throws Throwable {
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(fname); 
	}

	@When("^candidate enter last name \"(.*)\"$")
	public void candidate_enter_last_name(String lname) throws Throwable {
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lname);
	}

	@When("^candidate enters email \"(.*)\"$")
	public void candidate_enters_email(String Email) throws Throwable {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Email);  
	}

	@When("^candidate enters password \"(.*)\"$")
	public void candidate_enters_password(String pwd) throws Throwable {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd); 
	}

	@When("^candidate enters conformpassword \"(.*)\"$")
	public void candidate_enters_conform_password(String cnfmpwd) throws Throwable {
		driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys(cnfmpwd);  
	}

	@When("^candidate accepts terms and conditions$")
	public void candidate_accepts_terms_and_conditions() throws Throwable {
		driver.findElement(By.xpath("//label[@class='bx--checkbox-label']")).click();  
	}

	@When("^candidate enters submit button of registration$")
	public void candidate_enters_submit_button_of_registration() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();  
	}

	@Given("^candidate click on click here to login$")
	public void candidate_click_on_click_here_to_login() throws Throwable {
		driver.findElement(By.xpath("//span[@class='xpa-link']")).click();
	}

	@When("^candidate enters email to login$")
	public void candidate_enters_email_to_login() throws Throwable {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("paul109637@gmail.com");
	}

	@When("^candidate enters password to login$")
	public void candidate_enters_password_to_login() throws Throwable {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Paul109637$"); 
	}

	@When("^candidate click on recaptcha button$")
	public void candidate_click_on_recaptcha_button() throws Throwable {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
	}

	@When("^candidate clicks on login button$")
	public void candidate_clicks_on_login_button() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}
		@Then("^Signed in Candidate click on Apply button of Job$")
		public void signed_in_Candidate_click_on_Apply_button_of_Job() throws Throwable {
			driver.findElement(By.xpath("//span[text()='Apply']")).click(); 
		}

@Then("^click on checkbox to recieve whatsapp notifications$")
public void click_on_checkbox_to_recieve_whatsapp_notifications() throws Throwable {
	driver.findElement(By.xpath("(//label[@class='bx--checkbox-label'])[1]")).click();
}

@Given("^click on Total Applications available on dashboard$")
public void click_on_Total_Applications_available_on_dashboard() throws Throwable {
	Thread.sleep(3000);
  driver.findElement(By.xpath("(//div[text()='Total Applications'])[1]")).click();
}
@Then("^select an application from list of applications$")
public void select_an_application_from_list_of_applications() throws Throwable {
	driver.findElement(By.xpath("(//label[@class='bx--checkbox-label'])[2]")).click();  
}

@Then("^Shortlist the selected Application$")
public void shortlist_the_selected_Application() throws Throwable {
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@class='bx--btn bx--btn--primary'])[6]")).click(); 
}

@Then("^add additional email recipients$")
public void add_additional_email_recipients() throws Throwable {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='emailshare']")).sendKeys("paulindia637@gmail.com");  
}

@Then("^click on Submit button to send email to candidate$")
public void click_on_Submit_button_to_send_email_to_candidate() throws Throwable {
	driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
}
@Given("^click on add to talent pool button after selecting candidate$")
public void click_on_add_to_talent_pool_button_after_selecting_candidate() throws Throwable {
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@class='bx--btn bx--btn--primary'])[5]")).click();
	driver.findElement(By.xpath("(//span[@class='bx--radio-button__appearance'])[2]")).click();
	Select choosebkt=new Select(driver.findElement(By.id("select-talentpool-bucket")));
	choosebkt.selectByVisibleText("Talent5");
	
}

@Then("^recruiter choose add to new bucket Option$")
public void recruiter_choose_add_to_new_bucket_Option() throws Throwable {
	//driver.findElement(By.xpath("(//span[@class='bx--radio-button__appearance'])[2]")).click();
}

@When("^recruiter names the new Bucket$")
public void recruiter_names_the_new_Bucket() throws Throwable {
	driver.findElement(By.xpath("//input[@id='bucketName']")).sendKeys("Talent7");
}

@Then("^Click on Submit Button of Talent pool$")
public void click_on_Submit_Button_of_Talent_pool() throws Throwable {
	driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click(); 
	}
@Given("^click on Add Email Button after selecting Candidate$")
public void click_on_Add_Email_Button_after_selecting_Candidate() throws Throwable {
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@class='bx--btn bx--btn--primary'])[10]")).click();
}

@Then("^choose Email template to send to candidate$")
public void choose_Email_template_to_send_to_candidate() throws Throwable {
	Select emailtemp=new Select(driver.findElement(By.xpath("(//select[@id='email-templates-list'])[2]")));
	emailtemp.selectByValue("1_shortlist");
}

@Then("^click on Submit button of EmailTemplates$")
public void click_on_Submit_button_of_EmailTemplates() throws Throwable {
	driver.findElement(By.xpath("(//button[text()='Submit'])[4]")).click();  
}	

@Given("^click on KIV after selecting candidate from Applicants list$")
public void click_on_KIV_after_selecting_candidate_from_Applicants_list() throws Throwable {
   driver.findElement(By.xpath("(//button[@class='bx--btn bx--btn--primary'])[8]")).click();
}

@Then("^choose as required by using toggle and submit$")
public void choose_as_required_by_using_toggle_and_submit() throws Throwable {
	driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
   
}
@Given("^Recruiter clicks on change stage option for selected Application$")
public void recruiter_clicks_on_change_stage_option_for_selected_Application() throws Throwable {
	Thread.sleep(2000);
   driver.findElement(By.xpath("(//button[@class='bx--btn bx--btn--primary'])[9]")).click();
  
}

@Then("^select the stage to send Application$")
public void select_the_stage_to_send_Application() throws Throwable {
	Thread.sleep(2000);
	WebElement changestage=driver.findElement(By.xpath("//input[@id='react-select-2-input']"));
	Thread.sleep(2000);
	changestage.sendKeys("Interview");
	Thread.sleep(2000);
	changestage.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	changestage.sendKeys(Keys.ENTER);
    Thread.sleep(2000); 
	
}

@Then("^click on submit after changing Stage$")
public void click_on_submit_after_changing_Stage() throws Throwable {
	driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
}
@Given("^click on download option to download cv of selected candidate$")
public void click_on_download_option_to_download_cv_of_selected_candidate() throws Throwable {
	Thread.sleep(2000);
	 driver.findElement(By.xpath("(//button[@class='bx--btn bx--btn--primary'])[11]")).click();   
}

@Then("^click on submit to download cv$")
public void click_on_submit_to_download_cv() throws Throwable {
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[text()='Submit'])[5]")).click();
	
}
@Then("^select the application by clicking on Name of the Candidate$")
public void select_the_application_by_clicking_on_Name_of_the_Candidate() throws Throwable {
	driver.findElement(By.xpath("(//span[text()='Vinay Bhargav'])[1]")).click();
}
@Given("^launch outlook and sign in with valid credentials$")
public void launch_outlook_and_sign_in_with_valid_credentials() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.get("https://outlook.office365.com/login"); 
    driver.findElement(By.xpath("(//div[@class='table-cell text-left content'])[1]")).click(); 
}
@When("^Recruiter clicks on candidate's application$")
public void recruiter_clicks_on_candidate_s_application() throws Throwable {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("(//span[text()='Vinay Bhargav'])[1]")).click();
driver.findElement(By.xpath("(//a[@class='sui-single-option-facet__link inactive'])[1]")).click();
driver.findElement(By.xpath("(//a[@class='sui-single-option-facet__link inactive'])[2]")).click();

}
}
