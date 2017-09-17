package issues.controllers;

import issues.entities.Issue;
import issues.exceptions.IssueControllerException;
import issues.exceptions.IssueServiceException;
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
public class OwnerControllerTest {

    private List<Issue> emptyList;
    private Issue emptyIssue;
    private String owner;
    private String id;


    @Mock
    private IssuesService issuesService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.emptyList = new ArrayList<>();
        this.emptyIssue = new Issue();
    }

    @Test
    public void testGetIssuesByOwner() {
        Mockito.when(issuesService.obtainIssuesByOwner(owner)).thenReturn(this.emptyList);
        List<Issue> result = this.issuesService.obtainIssuesByOwner(owner);
        Assert.assertEquals(result, this.emptyList);
    }

    @Test
    public void testGetIssueOwnerById() throws IssueServiceException {
        Mockito.when(issuesService.obtainIssuesByOwnerAndId(owner, id)).thenReturn(this.emptyIssue);
        Issue result = issuesService.obtainIssuesByOwnerAndId(owner, id);
        Assert.assertEquals(result, this.emptyIssue);
    }

    @Test(expected = IssueServiceException.class)
    public void testGetIssueOwnerByIdException() throws Exception {
        Mockito.when(issuesService.obtainIssuesByOwnerAndId(owner, id)).thenThrow(new IssueServiceException("error", new Throwable()));
        issuesService.obtainIssuesByOwnerAndId(owner, id);
    }

    @Test
    public void testCreateIssue() throws IssueServiceException {
        Mockito.when(issuesService.saveIssue(owner, this.emptyIssue)).thenReturn(this.emptyIssue);
        Issue result = issuesService.saveIssue(owner, this.emptyIssue);
        Assert.assertEquals(result, this.emptyIssue);
    }

    @Test(expected = IssueServiceException.class)
    public void testCreateIssueException() throws Exception {
        Mockito.when(issuesService.saveIssue(owner, this.emptyIssue)).thenThrow(new IssueServiceException("error", new Throwable()));
        issuesService.saveIssue(owner, this.emptyIssue);
    }

    @Test
    public void testUpdateIssue() throws IssueServiceException {
        Mockito.when(issuesService.updateIssue(owner, id, this.emptyIssue)).thenReturn(this.emptyIssue);
        Issue result = issuesService.updateIssue(owner, id, this.emptyIssue);
        Assert.assertEquals(result, this.emptyIssue);
    }

    @Test(expected = IssueServiceException.class)
    public void testUpdateIssueException() throws Exception {
        Mockito.when(issuesService.updateIssue(owner, id, this.emptyIssue)).thenThrow(new IssueServiceException("error", new Throwable()));
        issuesService.updateIssue(owner, id, this.emptyIssue);
    }

    @Test
    public void testLockIssue() throws IssueServiceException {
        Mockito.when(issuesService.lockAndUnlockIssue(owner, id, true)).thenReturn(this.emptyIssue);
        Issue result = issuesService.lockAndUnlockIssue(owner, id, true);
        Assert.assertEquals(result, this.emptyIssue);
    }

    @Test(expected = IssueServiceException.class)
    public void testLockIssueException() throws Exception {
        Mockito.when(issuesService.lockAndUnlockIssue(owner, id, true)).thenThrow(new IssueServiceException("error", new Throwable()));
        issuesService.lockAndUnlockIssue(owner, id, true);
    }

    @Test
    public void testUnlockIssue() throws IssueServiceException {
        Mockito.when(issuesService.lockAndUnlockIssue(owner, id, false)).thenReturn(this.emptyIssue);
        Issue result = issuesService.lockAndUnlockIssue(owner, id, false);
        Assert.assertEquals(result, this.emptyIssue);
    }

    @Test(expected = IssueServiceException.class)
    public void testUnlockIssueException() throws Exception {
        Mockito.when(issuesService.lockAndUnlockIssue(owner, id, false)).thenThrow(new IssueServiceException("error", new Throwable()));
        issuesService.lockAndUnlockIssue(owner, id, false);
    }

}
