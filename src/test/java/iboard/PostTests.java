package iboard;

import iboard.EntityPattern.PostModel;
import iboard.EntityPattern.ThreadModel;
import iboard.JPA.PostRepository;
import iboard.JPA.ThreadRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostTests {

    @Autowired
    ThreadRepository tRep;
    @Autowired
    PostRepository pRep;
    private static final String MSG = "Hello by test creation";
    @Test
    public void createNewPostTest(){

        ThreadModel thread = tRep.findFirstById((long) 1);
        PostModel post = new PostModel();
        post.setMsg(MSG);
        post.setThread(thread);
        pRep.save(post);
        Assert.assertNotNull(pRep.findFirstByMsg(MSG));
    }
}
