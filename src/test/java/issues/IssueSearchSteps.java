package issues;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import issues.entities.Issue;
import issues.exceptions.IssueServiceException;
import issues.repositories.IssueRepository;
import issues.services.IssuesService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rsanchpa on 17/09/2017.
 */
@WebAppConfiguration
@ContextConfiguration(classes= Application.class)
public class IssueSearchSteps {

    private List<Issue> listIssues = new ArrayList<>();

    @Autowired
    IssuesService issuesService;

    @Autowired
    IssueRepository issueRepository;


    @Given("the next issues already created in the system for the owner '(.+)'")
    public void createNewIssues (String owner, List<Issue> listIssues) throws IssueServiceException {
        for (Issue issue : listIssues) {
            this.issuesService.saveIssue(owner, issue);
        }
    }

    @When("^the user requests all the issues in the system$")
    public void searchIssues() {
        this.listIssues = this.issuesService.obtainAllIssues();
    }

    @Then("^it should be returned this list of issues with:$")
    public void checkFoundIssues(List<Issue> checkIssuesList) {
        List<Issue> listResult = this.listIssues.stream().filter(p -> (!p.getId().equals(null))).collect(Collectors.toList());
        Assert.assertEquals(checkIssuesList.size(), listResult.size());
    }

    @Then("^it should be returned this list of issues with '(.+)' elements$")
    public void countFoundIssues(long count) {
        Assert.assertTrue(count == listIssues.size());
    }

    @After
    public void tearDown() {
        this.issueRepository.deleteAll();
    }

}
