package issues.services;

import issues.entities.Issue;
import issues.repositories.IssueRepository;
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
public class IssueServiceTest {

    private List<Issue> emptyList;
    private Issue emptyIssue;
    private String owner;
    private String id;


    @Mock
    private IssueRepository issueRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.emptyList = new ArrayList<>();
        this.emptyIssue = new Issue();
    }
//
//    @Test
//    public void testGetAllIssues() {
//        Mockito.when(issueRepository.f()).thenReturn(this.emptyList);
//        List<Issue> result = this.issuesService.obtainAllIssues();
//        Assert.assertEquals(result, this.emptyList);
//    }
}
