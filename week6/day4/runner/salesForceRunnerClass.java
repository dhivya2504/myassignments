package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/features/salesforce.feature",glue = "stepDefintion")
public class salesForceRunnerClass extends AbstractTestNGCucumberTests{

}
