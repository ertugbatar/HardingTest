package hardingTest.Runner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


//contains the main method that runs the Selenium tests.
//multiple test classes are usually created, and each test class contains multiple test methods.
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        },

        features = "src/test/resources/features",
        tags = "@wip",
        glue = "/hardingTest/stepDefs",
        dryRun = false,
        strict = true
)
public class Runner {

    // sets up and tears the test environment for the entire test suite
    @BeforeClass // runs once before all the tests in the class are executed
    public static void setUp() {
        getAndSetVariables();
    }

    private static void getAndSetVariables() {
    }

    @AfterClass // runs once after all the tests in the class are executed. In this case
    public static void after() {
        closeDriver();
    }

    private static void closeDriver() {
    }
}




