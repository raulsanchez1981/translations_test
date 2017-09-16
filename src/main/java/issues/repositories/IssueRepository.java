package issues.repositories;

import issues.entities.Issue;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by rsanchpa on 16/09/2017.
 */
public interface IssueRepository extends MongoRepository<Issue, String> {

    List<Issue> findByOwner (String owner);

}
