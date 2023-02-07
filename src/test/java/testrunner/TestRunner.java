package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", 
                 glue = "stepdefinitionfiles", 
                 monochrome = true, 
                 plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
                 publish = true)

public class TestRunner {

}
