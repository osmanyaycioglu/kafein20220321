package com.training.spring.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final IllegalArgumentException exp) {
        return ErrorObj.newInstance()
                       .setMessage(exp.getMessage())
                       .setErrorCode(1002);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorObj handleException(final AccessDeniedException exp) {
        return ErrorObj.newInstance()
                       .setMessage(exp.getMessage())
                       .setErrorCode(3202);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final MethodArgumentNotValidException exp) {
        ErrorObj root = ErrorObj.newInstance()
                                .setMessage("validasyon patladı")
                                .setErrorCode(200);
        exp.getAllErrors()
           .forEach(e -> root.addSubError(ErrorObj.newInstance()
                                                  .setMessage(e.toString())
                                                  .setErrorCode(1003)));
        return root;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleException(final Exception exp) {
        exp.printStackTrace();
        if (exp instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                                 .body(ErrorObj.newInstance()
                                               .setMessage(exp.getMessage())
                                               .setErrorCode(5001));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(ErrorObj.newInstance()
                                           .setMessage(exp.getMessage())
                                           .setErrorCode(5000));
    }


}
