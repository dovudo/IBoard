package test.boards.artem.boards.routes;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import test.boards.artem.boards.Service.BoardService;
import test.boards.artem.boards.Service.StatusHelp;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletResponse;

@RestController
public class BoardApi {

    @Autowired
    BoardService service;

    @GetMapping("board/{b}")
    public String GetBoard(@PathVariable  String b){
        JsonObject json = new JsonObject();
        json.addProperty("board", b);
        return json.toString();
    }

    //Getting full list of boards
    @GetMapping("boards")
    public String GetAllBoards(){
    return service.getAllBoard();
    }

    //Create a new board
    @PostMapping("boards")
    public String newBoard(@RequestBody String data){
        return service.createBoard(data);

    }

    //Remove a boards by id
    @DeleteMapping("boards/{id}")
    public HttpStatus removeBoard(@PathVariable Long id){
        return service.removeBoard(id);
    }

    @GetMapping("test")
    public String test(){
        return "TEST";
    }

}
