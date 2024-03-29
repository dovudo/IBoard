package iboard.Service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityExistsException;

@ControllerAdvice
public class ExceptionGrubber {

    @Autowired
    Gson gson;

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT,code = HttpStatus.CONFLICT)
    @ResponseBody
    public String EntityExists(EntityExistsException e){
        return gson.toJson(new StatusInterface(HttpStatus.CONFLICT,e.getMessage()));
    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String IllegalException(IllegalArgumentException e){
        return gson.toJson(e.getMessage());
    }
}
