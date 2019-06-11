package iboard.Routes;
import com.google.gson.JsonObject;
import iboard.Service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ThreadApi {

    @Autowired
    ThreadService service;

    @GetMapping("threads/{b}")
    public String GetThread(@PathVariable  String b){
        JsonObject json = new JsonObject();
        json.addProperty("thread", b);
        return json.toString();
    }

    //Getting full list of threads
    @GetMapping("threads")
    public String GetAllThreads(){
    return service.getAllThreads();
    }

    //Getting thread list by tag
    @GetMapping("threads/{tag}")
    public String getAllThreadsByTag(@PathVariable String tag){
        return service.getAllThreadsByTag(tag);
    }

    //Create a new thread
    @PostMapping("threads")
    public String newThread(@RequestBody String data){
        return service.createThread(data);
    }

    //Remove a thread by id
    @DeleteMapping("threads/{id}")
    public HttpStatus removeThread(@PathVariable Long id){
        return service.removeThread(id);
    }

    @GetMapping("test")
    public String test(){
        return "TEST";
    }

}
