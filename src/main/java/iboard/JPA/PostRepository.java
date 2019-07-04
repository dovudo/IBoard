package iboard.JPA;

import iboard.EntityPattern.PostModel;
import iboard.EntityPattern.ThreadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostModel,Long> {

    List<PostModel> findAll();
    PostModel findFirstById(Long id);
    List<PostModel> findAllByThread(ThreadModel thread);
    PostModel findFirstByMsg(String msg);
    //PostModel findTopById(Long id);
    //boolean existsByMsg(String Msg);
    //PostModel findByThread_id(Long id);
}
