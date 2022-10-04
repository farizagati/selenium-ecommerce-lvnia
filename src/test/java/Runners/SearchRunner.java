package Runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"classpath:features"},
        tags = "@search" ,
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"},
        monochrome = true, dryRun = false
)

public class SearchRunner extends AbstractTestNGCucumberTests {
}
