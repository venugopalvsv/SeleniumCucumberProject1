package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import cucumber.api.*;

@RunWith(Cucumber.class)
@CucumberOptions(
//		features=".//Features/",  // to run all feature files 
//		features=".//Features/Customers.feature", // to run a single feature file
		features={".//Features/Customers.feature",".//Features/Login.feature"}, // to run multiple/selected feature files 
		glue="stepDefinitions", // same applicable for multiple step definitions
		dryRun=false, //it will cross check whether for every feature file step, methods are implemented of not 
// Make dryrun=false when u want to execute the actual script
		monochrome=true, //It will remove unnecessary charactors
		plugin= {"pretty","html:test-output"}, // For reporting // HTML Report
// to run specific scenarios
		tags= {"@Sanity"}
//   	tags= {"@Sanity, @Regression"}
		)
public class TestRun {

}