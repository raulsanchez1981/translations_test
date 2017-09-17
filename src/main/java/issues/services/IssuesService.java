package issues.services;

import issues.entities.Issue;
import issues.exceptions.IssueServiceException;

import java.util.List;

/**
 * Created by rsanchpa on 16/09/2017.
 */
public interface IssuesService {

    List<Issue> obtainAllIssues ();

    List<Issue> obtainIssuesByOwner (String owner);

    Issue obtainIssuesByOwnerAndId (String owner, String id) throws IssueServiceException;

    Issue saveIssue (String owner, Issue issue) throws IssueServiceException;

    Issue updateIssue (String owner, String id, Issue issue) throws IssueServiceException;

    Issue lockAndUnlockIssue (String owner, String id, Boolean lock) throws IssueServiceException;
}
