package com.demo.chess.exception.handler;

import com.demo.chess.exception.EntityDuplicationException;
import com.demo.chess.exception.GameByIdNotFoundException;
import com.demo.chess.exception.LobbyByIdNotFoundException;
import com.demo.chess.exception.UserByIdNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionInterceptor {

    private final static String ERROR = "error";

    @ExceptionHandler({UserByIdNotFoundException.class, GameByIdNotFoundException.class, LobbyByIdNotFoundException.class})
    public ResponseEntity<Map<String, String>> handleEntityNotFoundException(Exception e) {
        log.warn(e.getMessage(), e);
        Map<String, String> errors = new HashMap<>();
        errors.put(ERROR, e.getLocalizedMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errors);
    }

    @ExceptionHandler({EntityDuplicationException.class, IllegalArgumentException.class})
    public ResponseEntity<Map<String, String>> handleEntityDuplicationException(Exception e) {
        log.warn(e.getMessage(), e);
        Map<String, String> errors = new HashMap<>();
        errors.put(ERROR, e.getLocalizedMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error-> {
            String fieldName = ((FieldError) error).getField();
            errors.put(fieldName, error.getDefaultMessage());
        });
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Map<String, String>> handleInternalError(Exception e) {
        log.warn(e.getMessage(), e);
        Map<String, String> errors = new HashMap<>();
        errors.put(ERROR, e.getLocalizedMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errors);
    }
}