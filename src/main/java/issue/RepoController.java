package issue;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/repos")
public class RepoController {



    private Map<String, List<Issue>> issueSchema = new HashMap<>();


    @ApiOperation(value = "getIssuesRepo", nickname = "getIssuesRepo")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "owner", value = "Name of the User Owner", required = false, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "repo", value = "Name of the Repository", required = false, dataType = "string", paramType = "path")
    })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Issue.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method=RequestMethod.GET, value="/{owner}/{repo}/issues")
    public List<Issue> getIssuesRepo(@PathVariable String owner, @PathVariable String repo) {
        List<Issue> listResult = new ArrayList<>();
        if (null != this.getIssueSchema().get(repo)) {
            listResult = this.getIssueSchema().get(repo).stream().filter(p -> p.getOwner().equalsIgnoreCase(owner)).collect(Collectors.toList());
        }
        return listResult;
    }

    @RequestMapping(method=RequestMethod.GET, value="/{owner}/{repo}/issues/{id}")
    public Issue getIssueRepoById(@PathVariable String owner, @PathVariable String repo, @PathVariable Long id) {
        List<Issue> listResult = new ArrayList<>();
        Issue issueResult = null;
        if (null != this.getIssueSchema().get(repo)) {
            listResult = this.getIssueSchema().get(repo).stream().filter(p -> (p.getOwner().equalsIgnoreCase(owner) && p.getId().equals(id))).collect(Collectors.toList());
        }
        if (!listResult.isEmpty()) {
            issueResult = listResult.get(0);
        }
        return issueResult;
    }

    @RequestMapping(method= RequestMethod.POST, value="/{owner}/{repo}/issues")
    public Issue createIssue(@PathVariable String owner, @PathVariable String repo, @RequestBody Issue issue) {
        if (null != this.getIssueSchema().get(repo)) {
            this.getIssueSchema().get(repo).add(issue);
        }
        return issue;
    }

    @RequestMapping(method= RequestMethod.PATCH, value="/{owner}/{repo}/issues/{id}")
    public Issue updateIssue(@PathVariable String owner, @PathVariable String repo, @PathVariable Long id, @RequestBody Issue issue) {
        return mapIssue(this.getIssueRepoById(owner, repo, id), issue);
    }


    @RequestMapping(method= RequestMethod.PUT, value="/{owner}/{repo}/issues/{id}/lock")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void lockIssue(@PathVariable String owner, @PathVariable String repo, @PathVariable Long id) {
        if (null != this.getIssueSchema().get(repo)) {
            this.getIssueSchema().get(repo).stream().filter(p -> (p.getOwner().equalsIgnoreCase(owner) && p.getId().equals(id))).forEach(p -> p.setLocked(true));
        }
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/{owner}/{repo}/issues/{id}/lock")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void unlockIssue(@PathVariable String owner, @PathVariable String repo, @PathVariable Long id) {
        if (null != this.getIssueSchema().get(repo)) {
            this.getIssueSchema().get(repo).stream().filter(p -> (p.getOwner().equalsIgnoreCase(owner) && p.getId().equals(id))).forEach(p -> p.setLocked(false));
        }
    }


    public Map<String, List<Issue>> getIssueSchema() {
        return issueSchema;
    }

    private Issue mapIssue (Issue oldIssue, Issue newIssue) {
        if (null != oldIssue && null != newIssue) {
            if (null != newIssue.getDirection()){
                oldIssue.setDirection(newIssue.getDirection());
            }
        }
        return oldIssue;
    }
}
