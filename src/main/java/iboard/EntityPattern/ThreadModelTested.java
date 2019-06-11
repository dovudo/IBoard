/*
package iboard.EntityPattern;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "post", schema = "public")
public class ThreadModelTested {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private ThreadModel boards;

    @Column(name = "data")
    @Lob
    @NotNull
    private String data;

    @Column(name = "timestamp")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ThreadModel getBoards() {
        return boards;
    }

    public void setBoards(ThreadModel boards) {
        this.boards = boards;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
*/
