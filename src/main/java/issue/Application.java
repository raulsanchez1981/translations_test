package issue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

import static springfox.documentation.builders.PathSelectors.regex;

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
