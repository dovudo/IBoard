package test.boards.artem.boards.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import test.boards.artem.boards.EntityPattern.BoardModel;
import test.boards.artem.boards.JPA.BoardRepository;

import javax.persistence.EntityExistsException;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRep;
    private Gson gson = new Gson();
    @Autowired
    private StatusHelp status;
    private static final Logger logs = LoggerFactory.getLogger(BoardService.class);

    public String createBoard(String jsonBoard) throws EntityExistsException{

        JsonObject jsonObject = gson.fromJson(jsonBoard, JsonObject.class);
        BoardModel board = new BoardModel();
        String BoardName = jsonObject.get("name").getAsString();
        board.setBoardName(BoardName);

        if(boardRep.existsByName(BoardName))
            throw new EntityExistsException("This Board name is exist " + board.getBoardName());
        if(jsonObject.get("subject") != null)
            board.setBoardSubject(jsonObject.get("subject").getAsString());
        if(jsonObject.get("description") != null)
            board.setBoardDescription(jsonObject.get("description").getAsString());
        logs.info("Created new board " + BoardName);
        boardRep.save(board);
        return gson.toJson(board);
    }

    public String getAllBoard(){
       return gson.toJson(boardRep.findAll());
    }

    public HttpStatus removeBoard(Long id){
        try {
            Optional<BoardModel> board = boardRep.findById(id);
            boardRep.delete(board.get());
            return HttpStatus.OK;
        }
        catch (NoSuchElementException e){
            return HttpStatus.NOT_FOUND;
        }
    }
}

