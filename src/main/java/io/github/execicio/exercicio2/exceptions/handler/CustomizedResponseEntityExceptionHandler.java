package io.github.execicio.exercicio2.exceptions.handler;

import java.util.Date;

import org.hibernate.JDBCException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.github.execicio.exercicio2.exceptions.ExceptionResponse;
import io.github.execicio.exercicio2.exceptions.RequiredObjectIsNullException;
import io.github.execicio.exercicio2.exceptions.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
  
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handlerAllExceptions(
    Exception ex, WebRequest request
  ) {

    ExceptionResponse exceptionResponse = new ExceptionResponse(
      new Date(),
      ex.getMessage(),
      request.getDescription(false)
    );

    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  @ExceptionHandler(ResourceNotFoundException.class)
  public final ResponseEntity<ExceptionResponse> handlerResourceNotFoundExceptions(
    Exception ex, WebRequest request
  ) {

    ExceptionResponse exceptionResponse = new ExceptionResponse(
      new Date(),
      ex.getMessage(),
      request.getDescription(false)
    );

    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(RequiredObjectIsNullException.class)
  public final ResponseEntity<ExceptionResponse> handlerRequiredObjectIsNullExceptions(
    Exception ex, WebRequest request
  ) {

    ExceptionResponse exceptionResponse = new ExceptionResponse(
      new Date(),
      ex.getMessage(),
      request.getDescription(false)
    );

    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

}
