package iboard.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import iboard.EntityPattern.PostModel;
import iboard.EntityPattern.ThreadModel;
import iboard.JPA.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

@Service
public class PostService {

    @Autowired
    PostRepository postRep;
    Gson gson = new Gson();
    PostModel post = new PostModel();
    Logger logs = LoggerFactory.getLogger("PostService");

    public String createPost(String jsonPost){
        JsonObject jsonObject = gson.fromJson(jsonPost, JsonObject.class);
        String msg = jsonObject.get("msg").getAsString();
        ThreadModel thread = gson.fromJson(jsonObject.get("thread_id"),ThreadModel.class);
        //if(postRep.existsByTag(msg))
        //   throw new EntityExistsException("This Board tag is exist " + thread.getThreadTag());
        post.setMsg(msg);

        if(jsonObject.get("ref") != null)
            post.setRef(jsonObject.get("ref").getAsString());
        logs.info("Created new thread " + post.getId());
        postRep.save(post);
        return gson.toJson(post);
    }

    public String getAllByThread(Long id){
        return gson.toJson(postRep.findAllByThread(id));
    }
    public String getAll(){
        return gson.toJson(postRep.findAll());
    }
}
