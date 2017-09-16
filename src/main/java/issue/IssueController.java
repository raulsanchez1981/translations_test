package issue;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "Obtain All Issues")
@RestController
public class IssueController {

    //private static final String template = "Hello, %s!";
    //private final AtomicLong counter = new AtomicLong();

    private List<Issue> issueList = new ArrayList<>();

    @ApiOperation(value = "getAllIssues", nickname = "getAllIssues")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "filter", value = "Indicates which sorts of issues to return", required = false, dataType = "string", paramType = "query", defaultValue="assigned")
    })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Issue.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method = RequestMethod.GET, value = "/issues")
    public List<Issue> getAllIssues(@RequestParam(value="filter", defaultValue="assigned") String filter) {
        return this.getIssueList();
    }



    public List<Issue> getIssueList() {
        return issueList;
    }

}
