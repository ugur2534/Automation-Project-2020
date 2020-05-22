package com.usa.myrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

        @CucumberOptions(
		features = { "Features" },
		plugin = {"pretty", "html:target/cucumber-reports/cucumber.json",
		"json:target/cucumber.json"},
		dryRun = false,
		monochrome  = true,
		strict = true,
        glue = {"com.usa.stepdefinition"}) 
    	//tags = { "@iphone, @laptop," })
public class MyRunner extends AbstractTestNGCucumberTests {

}
