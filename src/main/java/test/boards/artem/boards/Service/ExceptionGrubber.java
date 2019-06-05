package test.boards.artem.boards.Service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import test.boards.artem.boards.Service.StatusHelp;

import javax.persistence.EntityExistsException;

@ControllerAdvice
public class ExceptionGrubber {

    @Autowired
    Gson gson;

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT,code = HttpStatus.CONFLICT)
    @ResponseBody
    public String EntityExists(EntityExistsException e){
        return gson.toJson(new StatusHelp(HttpStatus.CONFLICT,e.getMessage()));
    }
}
