package iboard.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import iboard.EntityPattern.ThreadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import iboard.JPA.ThreadRepository;

import javax.persistence.EntityExistsException;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class ThreadService {

    @Autowired
    private ThreadRepository threadRep;
    private Gson gson = new Gson();
    @Autowired
    private StatusInterface status;
    private static final Logger logs = LoggerFactory.getLogger(ThreadService.class);

    public String createThread(String jsonBoard) throws EntityExistsException{

        JsonObject jsonObject = gson.fromJson(jsonBoard, JsonObject.class);
        ThreadModel thread = new ThreadModel();
        String ThreadTag = jsonObject.get("tag").getAsString();
        thread.setThreadTag(ThreadTag);

        if(threadRep.existsByTag(ThreadTag))
            throw new EntityExistsException("This Board tag is exist " + thread.getThreadTag());
        if(jsonObject.get("subject") != null)
            thread.setThreadSubject(jsonObject.get("subject").getAsString());
        if(jsonObject.get("description") != null)
            thread.setThreadDescription(jsonObject.get("description").getAsString());
        logs.info("Created new board " + ThreadTag);
        threadRep.save(thread);
        return gson.toJson(thread);
    }

    public String getAllThreads(){
       return gson.toJson(threadRep.findAll());
    }

    public String getAllThreadsByTag(String tag){
        return gson.toJson(threadRep.findAllByTag(tag));
    }

    public HttpStatus removeThread(Long id){
        try {
            Optional<ThreadModel> thread = threadRep.findById(id);
            threadRep.delete(thread.get());
            return HttpStatus.OK;
        }
        catch (NoSuchElementException e){
            return HttpStatus.NOT_FOUND;
        }
    }
}

