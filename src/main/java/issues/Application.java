package issues;

import issues.controllers.IssueController;
import issues.controllers.RepoController;
import issues.entities.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private IssueController issueController;

    @Autowired
    private RepoController repoController;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        issueController.getIssueList().add(new Issue(1L, "assigned", "open", "bug", "created", "desc", "Raul"));
        issueController.getIssueList().add(new Issue(2L, "created", "open", "bug", "created", "desc", "John"));
        issueController.getIssueList().add(new Issue(3L, "subscribed", "open", "bug", "created", "desc", "No One"));
        repoController.getIssueSchema().put("repo1", issueController.getIssueList());
    }


}
