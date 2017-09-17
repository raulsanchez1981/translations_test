package issues.controllers;

import issues.entities.Issue;
import issues.services.IssuesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsanchpa on 17/09/2017.
 */
public class IssueControllerTest {

    private List<Issue> emptyList;


    @Mock
    private IssuesService issuesService;

    @Mock
    private IssueController issueController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.emptyList = new ArrayList<>();
    }

    @Test
    public void testGetAllIssues() {
        Mockito.when(issuesService.obtainAllIssues()).thenReturn(this.emptyList);
        List<Issue> result = this.issueController.getAllIssues();
        Assert.assertEquals(result, this.emptyList);
    }
}
