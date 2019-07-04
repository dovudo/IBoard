package iboard.Routes;

import com.google.gson.Gson;
import iboard.EntityPattern.BoardModel;
import iboard.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApi {

    @Autowired
    BoardService service;
    private Gson gson = new Gson();

    @GetMapping(name = "boards")
    public String getAllBoards(){
        return service.getAllBoards();
    }

    @PostMapping(name = "board")
    public void createBoard(@RequestBody String board_json){
        BoardModel board = gson.fromJson(board_json, BoardModel.class);
        service.addToBoard(board);
    }
}
