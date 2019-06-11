package iboard.JPA;

import iboard.EntityPattern.ThreadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThreadRepository extends JpaRepository<ThreadModel, Long> {

    ThreadModel findByTag(String name);
    ThreadModel findFirstById(Long id);
    List<ThreadModel> findAllByTag(String tag);
    List<ThreadModel> findAll();
    boolean existsByTag(String tag);
}
