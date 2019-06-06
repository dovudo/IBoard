package iboard.EntityPattern;

import io.micrometer.core.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "thread_id")
    @NotNull
    ThreadModel thread_id;
    @Column(name = "msg")
    @NotNull
    @Max(512)
    String msg;
    @Column(name = "ref")
    @Nullable
    String ref;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ThreadModel getThread_id() {
        return thread_id;
    }

    public void setThread_id(ThreadModel thread_id) {
        this.thread_id = thread_id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Nullable
    public String getRef() {
        return ref;
    }

    public void setRef(@Nullable String ref) {
        this.ref = ref;
    }
}
