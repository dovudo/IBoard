package test.boards.artem.boards.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Service
 public class StatusHelp {

    private HttpStatus status;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp = new Date();

    public String getMassage() {
        return massage;
    }

    public StatusHelp(HttpStatus status,String massage){
        this.setStatus(status);
        this.setMassage(massage);
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    private String massage;

    public StatusHelp() {
    }
//
//    public String getJson(){
//
//    }

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
