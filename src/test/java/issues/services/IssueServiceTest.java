package issues.services;

import issues.entities.Issue;
import issues.exceptions.IssueControllerException;
import issues.exceptions.IssueServiceException;
import issues.repositories.IssueRepository;
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
public class IssueServiceTest {

    private List<Issue> emptyList;
    private Issue emptyIssue;
    private Issue lockIssue;
    private Issue unLockIssue;
    private String owner="owner";
    private String id="id";


    @Mock
    private IssueRepository issueRepository;

    @InjectMocks
    private IssuesServiceImpl issuesService;

    @Before
    public void setUp() {
        this.emptyList = new ArrayList<>();
        this.emptyIssue = new Issue();
        this.lockIssue = new Issue();
        this.unLockIssue = new Issue();
        lockIssue.setLocked(true);
        unLockIssue.setOwner(owner);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testObtainAllIssues() {
        Mockito.when(issueRepository.findAll()).thenReturn(this.emptyList);
        List<Issue> result = this.issuesService.obtainAllIssues();
        Assert.assertEquals(result, this.emptyList);
    }

    @Test
    public void testObtainIssuesByOwnerAndId() throws Exception {
        Mockito.when(issueRepository.findOne(id)).thenReturn(this.unLockIssue);
        Issue result = this.issuesService.obtainIssuesByOwnerAndId(owner,id);
        Assert.assertEquals(result, this.unLockIssue);
    }

    @Test(expected = IssueServiceException.class)
    public void testObtainIssuesByOwnerAndIdWithWrongId() throws Exception {
        Mockito.when(issueRepository.findOne(id)).thenReturn(null);
        this.issuesService.obtainIssuesByOwnerAndId(owner,id);
    }

    @Test(expected = IssueServiceException.class)
    public void testObtainIssuesByOwnerAndIdWithWrongOwner() throws Exception {
        Mockito.when(issueRepository.findOne(id)).thenReturn(this.lockIssue);
        this.issuesService.obtainIssuesByOwnerAndId(owner,id);
    }

    @Test
    public void testSaveIssue() throws Exception {
        Mockito.when(issueRepository.save(this.emptyIssue)).thenReturn(this.unLockIssue);
        Issue result = this.issuesService.saveIssue(owner,this.emptyIssue);
        Assert.assertEquals(result, this.unLockIssue);
    }

    @Test(expected = IssueServiceException.class)
    public void testCreateIssueException() throws Exception {
        Mockito.when(issueRepository.save(this.emptyIssue)).thenThrow(new NullPointerException());
        issuesService.saveIssue(owner, this.emptyIssue);
    }

    @Test
    public void testUpdateIssue() throws Exception {
        Mockito.when(issueRepository.findOne(id)).thenReturn(this.unLockIssue);
        Mockito.when(issueRepository.save(this.unLockIssue)).thenReturn(this.unLockIssue);
        Issue result = this.issuesService.updateIssue(owner,id,this.emptyIssue);
        Assert.assertEquals(result, this.unLockIssue);
    }

    @Test(expected = IssueServiceException.class)
    public void testUpdateIssueException() throws Exception {
        Mockito.when(issueRepository.save(this.emptyIssue)).thenThrow(new NullPointerException());
        issuesService.updateIssue(owner, id, this.emptyIssue);
    }

    @Test
    public void testLockIssue() throws Exception {
        Mockito.when(issueRepository.findOne(id)).thenReturn(this.unLockIssue);
        Mockito.when(issueRepository.save(this.emptyIssue)).thenReturn(this.lockIssue);
        this.issuesService.lockAndUnlockIssue(owner,id,true);
        Assert.assertEquals(this.lockIssue.getLocked(), true);
    }

    @Test
    public void testUnlockIssue() throws Exception {
        Mockito.when(issueRepository.findOne(id)).thenReturn(this.unLockIssue);
        Mockito.when(issueRepository.save(this.emptyIssue)).thenReturn(this.unLockIssue);
        this.issuesService.lockAndUnlockIssue(owner,id,false);
        Assert.assertEquals(this.unLockIssue.getLocked(), false);
    }

    @Test(expected = IssueServiceException.class)
    public void testLockIssueException() throws Exception {
        Mockito.when(issueRepository.save(this.emptyIssue)).thenThrow(new NullPointerException());
        this.issuesService.lockAndUnlockIssue(owner,id,true);
    }

    @Test(expected = IssueServiceException.class)
    public void testUnlockIssueException() throws Exception {
        Mockito.when(issueRepository.save(this.emptyIssue)).thenThrow(new NullPointerException());
        this.issuesService.lockAndUnlockIssue(owner,id,false);
    }
}
