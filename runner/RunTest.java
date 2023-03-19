package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/Features/changerequest_background.feature",glue="steps",tags="@Initial or @query or @smoke or @MultipleQP",publish=true)
public class RunTest extends AbstractTestNGCucumberTests{

}
