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

    @GetMapping("posts")
    public String getAllPosts(){
        return (service.getAll());
    }

    /*
    Getting posts by thread id
    */
    @GetMapping("post/{id}")
    public String getAllByThread(@PathVariable Long id){
        return service.getAllByThread(id);
    }

    @PostMapping("post")
    public String createPost(@RequestBody String json){
        return service.createPost(json);
    }
}
