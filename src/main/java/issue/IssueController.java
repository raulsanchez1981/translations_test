package issue;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IssueController {

    //private static final String template = "Hello, %s!";
    //private final AtomicLong counter = new AtomicLong();

    private List<Issue> issueList = new ArrayList<>();

    @RequestMapping("/issues")
    public List<Issue> getAllIssues(@RequestParam(value="filter", defaultValue="assigned") String filter) {
        return this.getIssueList();
    }



    public List<Issue> getIssueList() {
        return issueList;
    }

}
