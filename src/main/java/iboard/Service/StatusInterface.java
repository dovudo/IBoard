package iboard.Service;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Service
 public class StatusInterface {

    private HttpStatus status;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp = new Date();
    private String message = "Something going wrong!";


    public String getMessage() {
        return message;
    }

    public StatusInterface(HttpStatus status, String message){
        this.setStatus(status);
        this.setMessage(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StatusInterface() {
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}
