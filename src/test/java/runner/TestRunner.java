package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ConfigurationParameters;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

//import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
//import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
//import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;

import org.junit.jupiter.api.AfterAll;

import pages.BasePage;

@Suite 
@IncludeEngines("cucumber") //Cucumber engine activated
@SelectClasspathResource("features") //It indicates where are the .feature
@ConfigurationParameters({
    @ConfigurationParameter(key = "cucumber.glue", value = "steps"), //Package where are the steps
    @ConfigurationParameter(key = "cucumber.gilter.tags", value = "@QaseId=2"),
})

public class TestRunner {
    @AfterAll
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}

