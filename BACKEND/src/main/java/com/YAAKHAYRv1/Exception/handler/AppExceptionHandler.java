//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.YAAKHAYRv1.Exception.handler;

import com.YAAKHAYRv1.Exception.EntityAlreadyExisitsException;
import com.YAAKHAYRv1.Exception.EntityNotFoundException;
import com.YAAKHAYRv1.shared.ErrorMessage;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
    public AppExceptionHandler() {
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException exception) {
        ErrorMessage errorMessage = ErrorMessage.builder().message(exception.getMessage()).timestamp(new Date()).code(404).build();
        return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EntityAlreadyExisitsException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityAlreadyExisitsException exception) {
        ErrorMessage errorMessage = ErrorMessage.builder().message(exception.getMessage()).timestamp(new Date()).code(409).build();
        return new ResponseEntity(errorMessage, HttpStatus.CONFLICT);
    }
}
