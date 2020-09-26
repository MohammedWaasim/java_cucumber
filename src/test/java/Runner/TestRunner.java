package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src\\test\\resources\\features\\Beta1.feature",
		glue = "StepDefinations",
		plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json", 
				"rerun:target/rerun.txt", "junit:target/cucumber.xml"
				
		}, tags = "@WeInvest_Scenario"
		
		)



public class TestRunner {

}
