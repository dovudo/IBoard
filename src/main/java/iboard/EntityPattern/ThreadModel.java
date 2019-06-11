package iboard.EntityPattern;

import io.micrometer.core.lang.Nullable;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "thread", schema = "public")
public class ThreadModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tag")
    private String tag = "B";

    @Column(name = "subject")
    @Nullable
    private String ThreadSubject = "Default Subject";

    @Column(name = "description")
    @Nullable
    private String ThreadDescription = "Default Description";

    @Column(name = "timestamp", columnDefinition="TIMESTAMP")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp = new Date();

    public ThreadModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThreadTag() {
        return tag;
    }

    public void setThreadTag(String threadName) {
        tag = threadName;   }

    public String getThreadSubject() {
        return ThreadSubject;
    }

    public void setThreadSubject(String threadSubject) {
        ThreadSubject = threadSubject;
    }

    public String getThreadDescription() {
        return ThreadDescription;
    }

    public void setThreadDescription(String threadDescription) {
        ThreadDescription = threadDescription;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
