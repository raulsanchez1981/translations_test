package issues.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import issues.entities.Issue;
import issues.services.IssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "Obtain All Issues")
@RestController
public class IssueController {

    @Autowired
    IssuesService issuesService;


    @ApiOperation(value = "Obtain all Issues", nickname = "getAllIssues")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Issue.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method = RequestMethod.GET, value = "/issues")
    public List<Issue> getAllIssues() {
        return this.issuesService.obtainAllIssues();
    }

}
