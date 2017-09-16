package issues.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import issues.entities.Issue;
import issues.exceptions.IssueControllerException;
import issues.exceptions.IssueServiceException;
import issues.services.IssuesService;
import org.springframework.beans.factory.annotation.Autowired;
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

@Api(tags = "Manage Issues from a Particular Owner")
@RestController
@RequestMapping("/owner")
public class OwnerController {


    @Autowired
    IssuesService issuesService;


    @ApiOperation(value = "Obtain a List of Issues", nickname = "getIssuesByOwner")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "owner", value = "Name of the User Owner", required = true, dataType = "string", paramType = "path")
    })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Issue.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method=RequestMethod.GET, value="/{owner}/issues")
    public List<Issue> getIssuesByOwner(@PathVariable String owner) {
        return this.issuesService.obtainIssuesByOwner(owner);
    }


    @ApiOperation(value = "Obtain a Particular Issue", nickname = "getIssueOwnerById")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "owner", value = "Name of the User Owner", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "id", value = "Id of the Element", required = true, dataType = "string", paramType = "path")
    })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Issue.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure", response = IssueControllerException.class)})
    @RequestMapping(method=RequestMethod.GET, value="/{owner}/issues/{id}")
    public Issue getIssueOwnerById(@PathVariable String owner, @PathVariable String id) throws IssueControllerException {
////        List<Issue> listResult = new ArrayList<>();
////        Issue issueResult = null;
////        if (null != this.getIssueSchema().get(repo)) {
////            listResult = this.getIssueSchema().get(repo).stream().filter(p -> (p.getOwner().equalsIgnoreCase(owner) && p.getId().equals(id))).collect(Collectors.toList());
////        }
////        if (!listResult.isEmpty()) {
////            issueResult = listResult.get(0);
////        }
        try {
            return this.issuesService.obtainIssuesByOwnerAndId(owner, id);
        } catch (IssueServiceException e) {
            throw new IssueControllerException(e.getMessage(), e);
        }
    }

    @ApiOperation(value = "Create a New Issue", nickname = "createIssue")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "owner", value = "Name of the User Owner", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "issue", value = "Issue to add the System", required = true)
    })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Issue.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure", response = IssueControllerException.class)})
    @RequestMapping(method= RequestMethod.POST, value="/{owner}/{repo}/issues")
    public Issue createIssue(@PathVariable String owner, @RequestBody Issue issue) throws IssueControllerException {
        try {
            return this.issuesService.saveIssue(owner, issue);
        } catch (IssueServiceException e) {
            throw new IssueControllerException(e.getMessage(), e);
        }
    }


    @ApiOperation(value = "Update a Particular Issue", nickname = "updateIssue")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "owner", value = "Name of the User Owner", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "id", value = "Id of the Element", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "issue", value = "Issue to add the System", required = true)
    })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Issue.class),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure", response = IssueControllerException.class)})
    @RequestMapping(method= RequestMethod.PATCH, value="/{owner}/issues/{id}")
    public Issue updateIssue(@PathVariable String owner, @PathVariable String id, @RequestBody Issue issue) throws IssueControllerException {
        try {
            return this.issuesService.updateIssue(owner, id, issue);
        } catch (IssueServiceException e) {
            throw new IssueControllerException(e.getMessage(), e);
        }
    }

    @ApiOperation(value = "Lock an Issue", nickname = "lockIssue")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "owner", value = "Name of the User Owner", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "id", value = "Id of the Element", required = true, dataType = "string", paramType = "path")
    })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure", response = IssueControllerException.class)})
    @RequestMapping(method= RequestMethod.PUT, value="/{owner}/{repo}/issues/{id}/lock")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void lockIssue(@PathVariable String owner, @PathVariable String id) throws IssueControllerException {
        try {
            this.issuesService.lockAndUnlockIssue(owner,id,true);
        } catch (IssueServiceException e) {
            throw new IssueControllerException(e.getMessage(), e);
        }
    }

    @ApiOperation(value = "Unlock an Issue", nickname = "unlockIssue")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "owner", value = "Name of the User Owner", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "id", value = "Id of the Element", required = true, dataType = "string", paramType = "path")
    })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure", response = IssueControllerException.class)})
    @RequestMapping(method= RequestMethod.DELETE, value="/{owner}/{repo}/issues/{id}/lock")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void unlockIssue(@PathVariable String owner, @PathVariable String id) throws IssueControllerException {
        try {
            this.issuesService.lockAndUnlockIssue(owner, id, false);
        } catch (IssueServiceException e) {
            throw new IssueControllerException(e.getMessage(), e);
        }
    }


}
