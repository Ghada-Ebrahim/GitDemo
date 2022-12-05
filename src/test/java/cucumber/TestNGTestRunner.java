package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//monochrome gives the result in readable format
@CucumberOptions(features = "src/test/java/cucumber",tags = "@Regression",glue ="rahulshettyacademy.stepDefinition" ,monochrome = true,
plugin = {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
