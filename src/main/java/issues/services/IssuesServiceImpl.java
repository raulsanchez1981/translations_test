package issues.services;

import issues.entities.Issue;
import issues.exceptions.IssueServiceException;
import issues.repositories.IssueRepository;
import issues.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rsanchpa on 16/09/2017.
 */
@Service
public class IssuesServiceImpl implements IssuesService {

    @Autowired
    private IssueRepository issueRepository;

    public List<Issue> obtainAllIssues() {
        return this.issueRepository.findAll();
    }

    @Override
    public List<Issue> obtainIssuesByOwner(String owner) {
        return this.issueRepository.findByOwner(owner);
    }

    @Override
    public Issue obtainIssuesByOwnerAndId(String owner, String id) throws IssueServiceException {
        Issue issue = this.issueRepository.findOne(id);
        if (null == issue) {
            throw new IssueServiceException("Doesn't exist element with this id: "+id);
        }
        if (!owner.equalsIgnoreCase(issue.getOwner())) {
            throw new IssueServiceException("Wrong owner of the element with id: "+id);
        }
        return issue;
    }

    @Override
    public Issue saveIssue(String owner, Issue issue) throws IssueServiceException {
        issue.setOwner(owner);
        try {
            return this.issueRepository.save(issue);
        } catch (Exception e) {
            throw new IssueServiceException("Error saving the element", e);
        }
    }

    @Override
    public Issue updateIssue(String owner, String id, Issue issue) throws IssueServiceException {
        Issue issueOld = obtainIssuesByOwnerAndId(owner, id);
        Utilities.mapIssue(issueOld, issue);
        try{
          return this.issueRepository.save(issueOld);
        } catch (Exception e) {
            throw new IssueServiceException("Error updating the element", e);
        }
    }

    @Override
    public Issue lockAndUnlockIssue(String owner, String id, Boolean lock) throws IssueServiceException {
        Issue issue = obtainIssuesByOwnerAndId(owner, id);
        issue.setLocked(lock);
        try{
            return this.issueRepository.save(issue);
        } catch (Exception e) {
            if (lock) {
                throw new IssueServiceException("Error locking the element", e);
            }
            throw new IssueServiceException("Error unlocking the element", e);
        }
    }

}
