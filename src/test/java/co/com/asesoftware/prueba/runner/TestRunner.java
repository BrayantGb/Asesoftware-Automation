package co.com.asesoftware.prueba.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/co/com/asesoftware/prueba/features/",
        glue = {"co.com.asesoftware.prueba.stepdefinitions", "co.com.asesoftware.prueba.set.hook"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        tags = "@RegressionTest"
)
public class TestRunner {
}

