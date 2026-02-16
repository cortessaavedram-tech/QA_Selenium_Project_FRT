package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ConfigurationParameters;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite 
@IncludeEngines("cucumber") //Cucumber engine activated
@SelectClasspathResource("features") //It indicates where are the .feature
@IncludeClassNamePatterns(".*")
@ConfigurationParameters({
    @ConfigurationParameter(key = "cucumber.glue", value = "steps"), //Package where are the steps
    @ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:target/cucumber-reports.html, io.qase.cucumber7.QaseEventListener"),
    @ConfigurationParameter(key = "cucumber.filter.tags", value = "@smoke")
})

public class TestRunner {

}


