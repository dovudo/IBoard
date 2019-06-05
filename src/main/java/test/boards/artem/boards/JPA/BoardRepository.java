package test.boards.artem.boards.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.boards.artem.boards.EntityPattern.BoardModel;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardModel, Long> {

    BoardModel findByName(String name);
    List<BoardModel> findAllByName(String name);
    boolean existsByName(String name);
}
