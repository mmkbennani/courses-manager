package com.carrefour.exposition.cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import lombok.NoArgsConstructor;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "not @ignore",
		plugin = { "pretty" , "json:target/cucumber-reports/json/Cucumber.json",
				"junit:target/cucumber-reports/xml/Cucumber.xml",
				"html:target/cucumber-reports/html"},
		monochrome = true,
		glue = "com.carrefour.exposition.cucumber.steps",
		features = "classpath:it/features")
@NoArgsConstructor
public class PixcelProxyCucumberSuiteRunnerTest {
}
