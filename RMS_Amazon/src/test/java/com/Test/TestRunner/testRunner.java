package com.Test.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/BusinessLogic/Amazon", glue = { "com.Test.SD" }, plugin = { "pretty",
		"html:target/cucumber/AmazonReports.html" }, monochrome = true, dryRun = false, publish = true)
public class testRunner {

}
