package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@example and not @failed",
        features = {"src/test/resources/features"},
        glue = {"model","hooks"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "summary",
                "pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber-report.json",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"
        }
)

public class Runner {

}
