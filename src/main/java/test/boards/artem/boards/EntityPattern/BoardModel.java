package test.boards.artem.boards.EntityPattern;

import io.micrometer.core.lang.Nullable;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "boards", schema = "public")
public class BoardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name = "B";

    @Column(name = "subject")
    @Nullable
    private String BoardSubject = "Default Subject";

    @Column(name = "description")
    @Nullable
    private String BoardDescription = "Default Description";

    @Column(name = "timestamp", columnDefinition="TIMESTAMP")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoardName() {
        return name;
    }

    public void setBoardName(String boardName) {
        name = boardName;   }

    public String getBoardSubject() {
        return BoardSubject;
    }

    public void setBoardSubject(String boardSubject) {
        BoardSubject = boardSubject;
    }

    public String getBoardDescription() {
        return BoardDescription;
    }

    public void setBoardDescription(String boardDescription) {
        BoardDescription = boardDescription;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
