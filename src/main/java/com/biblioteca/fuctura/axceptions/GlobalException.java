package com.biblioteca.fuctura.axceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request){
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),e.getMessage(),request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
    }

    @ExceptionHandler(IllegalArgumentExcepetion.class)
    public ResponseEntity<StandardError> illegalArgumentExcepetion(IllegalArgumentExcepetion e, HttpServletRequest request){
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }

    @ExceptionHandler(DataIntegriyuViolationException.class)
    public ResponseEntity<StandardError> dataIntegriyuViolationException(DataIntegriyuViolationException e,HttpServletRequest request){
        StandardError se = new StandardError(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StandardError> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e,HttpServletRequest request){
        StandardError se = new StandardError(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }

}
