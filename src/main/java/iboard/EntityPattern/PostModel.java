package iboard.EntityPattern;

import io.micrometer.core.lang.Nullable;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "post", schema = "public")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Pid;
    @OneToOne
    @JoinColumn(name = "Tid")
    private ThreadModel thread;
    @Column(name = "msg")
    @NotNull
    private String msg;
    @Column(name = "ref")
    @Nullable
    private String ref;
    @Column(name = "timestamp", columnDefinition="TIMESTAMP")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp = new Date();


    public ThreadModel getThread() {
        return thread;
    }

    public void setThread(ThreadModel thread) {
        this.thread = thread;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return Pid;
    }

    public void setId(Long id) {
        this.Pid = id;
    }

    public ThreadModel getThread_id() {
        return thread;
    }

    public void setThread_id(ThreadModel thread) {
        this.thread = thread;
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
