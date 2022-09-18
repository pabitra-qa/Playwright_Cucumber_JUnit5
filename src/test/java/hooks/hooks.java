package hooks;

import io.cucumber.java.*;
import utils.Log;

import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;

import static factory.PlaywrightFactory.*;
import static utils.ConfigReader.getPropertyValue;

public class hooks {
    static String featureName;
    static HashSet<String> features = new HashSet<>();
@BeforeAll
public static void beforeAll(){
    Log.info("-----------------------------------------------------------------------------");
    Log.info("Tests Started!");
    Properties prop = new Properties();
    try {
        prop.load(hooks.class.getClassLoader().getResourceAsStream("config.properties"));
        String username = prop.getProperty("uname");
        String password = prop.getProperty("pass");
        Log.info("Retrieved from CLI. Username: "+username+" & Password: "+password);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
    @Before
    public void beforeTest(Scenario scenario) {
        String currentFeatureName = getFeatureNameFromScenario(scenario);

        if (!features.contains(currentFeatureName)) {
            featureName = currentFeatureName;
            features.add(featureName);
            closePlaywright();
            initializePage();
        }
    }

    @AfterAll
    public static void afterAll() {
        closePlaywright();
        String home = System.getProperty("user.dir");
        Log.info("Executed Features are: " + features);
        Log.info("Cucumber Report Generated: " + home + "\\target\\cucumber-report.html");
        Log.info("Allure Report Generated: allure serve " + home + "\\target\\allure-results");
        Log.info("Time Line Report Generated: " + home + "\\target\\timeline\\index.html");
        Log.info("Tests Complete!");
        Log.info("-----------------------------------------------------------------------------");
    }

    @After
    public void afterTest(Scenario scenario) {
        scenario.attach(getPage().screenshot(), "image/png", scenario.getName().replaceAll(" ", "_"));
    }

    public static String getFeatureNameFromScenario(Scenario scenario) {
        String[] test = scenario.getUri().toString().split("/");
        String[] longFeatureName = test[test.length - 1].split("\\.");
        return longFeatureName[0];
    }
}
