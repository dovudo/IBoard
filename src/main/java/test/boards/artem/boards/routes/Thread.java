package test.boards.artem.boards.routes;

import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Thread {

    @GetMapping("board/{B}/{T}")
    public String getThread(@PathVariable String B, @PathVariable String T){
        JsonObject json = new JsonObject();
        json.addProperty("board", B);
        json.addProperty("thread",T);
        return json.toString();
    }
}
