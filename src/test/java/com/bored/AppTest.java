package com.bored;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/App.feature",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class AppTest {
}
