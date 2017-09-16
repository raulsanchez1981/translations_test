package issues;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//
//        issueController.getIssueList().add(new Issue("assigned", "open", "bug", "created", "desc", "Raul"));
//        issueController.getIssueList().add(new Issue("created", "open", "bug", "created", "desc", "John"));
//        issueController.getIssueList().add(new Issue("subscribed", "open", "bug", "created", "desc", "No One"));
       // repoController.getIssueSchema().put("repo1", issueController.getIssueList());
    }


}
