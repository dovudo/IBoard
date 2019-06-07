package iboard.JPA;

import iboard.EntityPattern.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostModel,Long> {

    List<PostModel> findAll();
    //PostModel findTopById(Long id);
    PostModel findAllByThread(Long id);
    //boolean existsByMsg(String Msg);
    //PostModel findByThread_id(Long id);
}
