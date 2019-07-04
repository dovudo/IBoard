package iboard.Service;

import com.google.gson.Gson;
import iboard.EntityPattern.BoardModel;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class BoardService {

    private static final String filePath = "./boardsList.json";
    private final Gson gson = new Gson();
    private List<BoardModel> boardList;

    public void setBoardList(List boardList) {
        this.boardList = boardList;
    }

    private synchronized List getBoardList() {
        try (FileReader r = new FileReader(filePath)) {
            boardList = gson.fromJson(r, List.class);
            System.out.println(boardList.listIterator().next());
            return boardList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return boardList;
    }

    public synchronized void addToBoard(BoardModel model) throws IllegalArgumentException{
        if(model == null)
            throw new IllegalArgumentException("Nullable param got while create new board");
        else {
            List list = getBoardList();
            list.add(model);
            saveBoardList(list);
        }
    }

    private synchronized void saveBoardList(List list){
        try(FileWriter w = new FileWriter(filePath)){
            w.write(gson.toJson(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAllBoards(){
        return gson.toJson(getBoardList());
    }
}
