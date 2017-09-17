package issues.controllers;

import issues.entities.Issue;
import issues.exceptions.IssueControllerException;
import issues.exceptions.IssueServiceException;
import issues.services.IssuesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsanchpa on 17/09/2017.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
//@WebAppConfiguration
public class OwnerControllerTest {

    private List<Issue> emptyList;
    private Issue emptyIssue;
    private Issue lockIssue;
    private Issue unLockIssue;
    private String owner="owner";
    private String id="id";

    @Mock
    private IssuesService issuesService;

    @InjectMocks
    private OwnerController ownerController;


    @Before
    public void setUp() {
        //ownerController = new OwnerController();
        this.emptyList = new ArrayList<>();
        this.emptyIssue = new Issue();
        this.lockIssue = new Issue();
        this.unLockIssue = new Issue();
        lockIssue.setLocked(true);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetIssuesByOwner() {
        Mockito.when(issuesService.obtainIssuesByOwner(owner)).thenReturn(this.emptyList);
        List<Issue> result = this.ownerController.getIssuesByOwner(owner);
        Assert.assertEquals(result, this.emptyList);
    }

    @Test
    public void testGetIssueOwnerById() throws Exception {
        Mockito.when(this.issuesService.obtainIssuesByOwnerAndId(owner, id)).thenReturn(this.emptyIssue);
        Issue result = ownerController.getIssueOwnerById(owner, id);
        Assert.assertEquals(result, this.emptyIssue);
    }

    @Test(expected = IssueControllerException.class)
    public void testGetIssueOwnerByIdException() throws Exception {
        Mockito.when(issuesService.obtainIssuesByOwnerAndId(owner, id)).thenThrow(new IssueServiceException("error", new Throwable()));
        ownerController.getIssueOwnerById(owner, id);
    }

    @Test
    public void testCreateIssue() throws Exception {
        Mockito.when(issuesService.saveIssue(owner, this.emptyIssue)).thenReturn(this.emptyIssue);
        Issue result = ownerController.createIssue(owner, this.emptyIssue);
        Assert.assertEquals(result, this.emptyIssue);
    }

    @Test(expected = IssueControllerException.class)
    public void testCreateIssueException() throws Exception {
        Mockito.when(issuesService.saveIssue(owner, this.emptyIssue)).thenThrow(new IssueServiceException("error", new Throwable()));
        ownerController.createIssue(owner, this.emptyIssue);
    }

    @Test
    public void testUpdateIssue() throws Exception {
        Mockito.when(issuesService.updateIssue(owner, id, this.emptyIssue)).thenReturn(this.emptyIssue);
        Issue result = ownerController.updateIssue(owner, id, this.emptyIssue);
        Assert.assertEquals(result, this.emptyIssue);
    }

    @Test(expected = IssueControllerException.class)
    public void testUpdateIssueException() throws Exception {
        Mockito.when(issuesService.updateIssue(owner, id, this.emptyIssue)).thenThrow(new IssueServiceException("error", new Throwable()));
        ownerController.updateIssue(owner, id, this.emptyIssue);
    }

    @Test
    public void testLockIssue() throws Exception {
        Mockito.when(issuesService.lockAndUnlockIssue(owner, id, true)).thenReturn(lockIssue);
        ownerController.lockIssue(owner, id);
        Assert.assertEquals(lockIssue.getLocked(), true);
    }

    @Test(expected = IssueControllerException.class)
    public void testLockIssueException() throws Exception {
        Mockito.when(issuesService.lockAndUnlockIssue(owner, id, true)).thenThrow(new IssueServiceException("error", new Throwable()));
        ownerController.lockIssue(owner, id);
    }

    @Test
    public void testUnlockIssue() throws Exception {
        Mockito.when(issuesService.lockAndUnlockIssue(owner, id, true)).thenReturn(unLockIssue);
        ownerController.lockIssue(owner, id);
        Assert.assertEquals(unLockIssue.getLocked(), false);
    }

    @Test(expected = IssueControllerException.class)
    public void testUnlockIssueException() throws Exception {
        Mockito.when(issuesService.lockAndUnlockIssue(owner, id, false)).thenThrow(new IssueServiceException("error", new Throwable()));
        ownerController.unlockIssue(owner, id);
    }

}
