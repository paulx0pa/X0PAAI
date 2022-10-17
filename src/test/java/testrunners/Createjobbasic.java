package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="Featurefiles/createbasicjob.feature",glue="stepdefinitions",dryRun=false,
plugin={"com.cucumber.listener.ExtentCucumberFormatter:Reports/createjobbasic.html"})
public class Createjobbasic extends AbstractTestNGCucumberTests {

}
