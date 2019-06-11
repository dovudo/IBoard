package iboard.Routes;

import com.google.gson.JsonObject;
import iboard.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostApi {

    @Autowired
    PostService service;
    @GetMapping("post/{B}/{T}")
    public String getThread(@PathVariable String B, @PathVariable String T){
        JsonObject json = new JsonObject();
        json.addProperty("board", B);
        json.addProperty("thread",T);
        return json.toString();
    }

    @GetMapping("post/getAll")
    public String getAll(){
        return (service.getAll());
    }

    @PostMapping("post")
    public String createPost(@RequestBody String json){
        return service.createPost(json);
    }

    @GetMapping("post/{id}")
    public String getAllByThread(@PathVariable String id){
       return service.getAllByThread(Long.valueOf(id));
    }
}
