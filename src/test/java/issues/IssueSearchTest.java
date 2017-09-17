package issues;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import issues.repositories.IssueRepository;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by rsanchpa on 17/09/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json" })
@ContextConfiguration(classes= Application.class)
public class IssueSearchTest {


}
