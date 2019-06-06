package iboard;


import com.google.gson.JsonArray;
import iboard.EntityPattern.BoardModel;
import iboard.Service.BoardService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

public class BoardTests {

    BoardService bs = new BoardService();
    BoardModel board = new BoardModel();
    List<BoardModel> list = new ArrayList<>();

    @Test
    public void saveJsonFileTest(){

        board.setTag("Test");
        board.setDescription("This is the test board, created from auto test, 2th test");
        list.add(board);
        System.out.println("Saving");
        bs.saveBoardList(list);
    }

    @Test
    public void getJsonFileTest(){
        bs.getBoardList();
    }

    @Test
    public void addNewOneTest(){
        board.setTag("Test");
        board.setDescription("Auto adding by addNewOne test");
        bs.addToBoard(board);
    }

}
