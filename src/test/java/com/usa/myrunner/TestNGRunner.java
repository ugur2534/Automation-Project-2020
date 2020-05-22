package com.usa.myrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

       @CucumberOptions(
		// features = Location of cucumber feature file
		features = { "Features" },
		// glue =  Location of step definition, Whenever Cucumber encounters a Step
		glue = "com.usa.stepdefinition",
		// If it is set as true, it means that Cucumber will only check that every Step  mentioned
		// in the Feature File has corresponding code written in Step Definition file or not.
		dryRun = false,
		// If it is set as true, it means that the console output for the Cucumber test are much
		//more readable. And if it is set as false, then the console
		// output is not as readable as it should be. For practice just add the code
		 monochrome = true,
		// : if strict option is set to false then at execution time if cucumber
		// encounters any undefined/pending steps
		strict = true, 
		
		tags = "@login",
		// Report design in format xml/json out put
		plugin = { "pretty", "html:target/cucumber-reports/cucumber.json",
				"json:target/cucumber.json" }
		// The tags can be used when specifying what tests to run through any of the
		// running mechanism.
		)
		//tags = { "@iphone, @laptop," })

public class TestNGRunner extends AbstractTestNGCucumberTests {

}