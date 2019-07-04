package iboard.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import iboard.EntityPattern.PostModel;
import iboard.EntityPattern.ThreadModel;
import iboard.JPA.PostRepository;
import iboard.JPA.ThreadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRep;

    @Autowired
    ThreadRepository threadRep;

    private Gson gson = new Gson();
    private final Logger logs = LoggerFactory.getLogger("PostService");

    public String createPost(String jsonPost){
        PostModel post = new PostModel();
        JsonObject jsonObject = gson.fromJson(jsonPost, JsonObject.class);
        String msg = jsonObject.get("msg").getAsString();
        ThreadModel thread = gson.fromJson(jsonObject.get("thread_id"),ThreadModel.class);
        post.setThread(thread);
        post.setMsg(msg);

        if(jsonObject.get("ref") != null)
            post.setRef(jsonObject.get("ref").getAsString());
        logs.info("Created new post " + post.getId());
        postRep.save(post);
        return gson.toJson(post);
    }

    public String getAllByThread(Long id){
       ThreadModel thread = threadRep.findFirstById(id);
        return gson.toJson(postRep.findAllByThread(thread));
    }
    public String getAll(){
        return gson.toJson(postRep.findAll());
    }
}
