package xyz.pangosoft.ispendpoints.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import xyz.pangosoft.ispendpoints.exception.exceptions.*;
import xyz.pangosoft.ispendpoints.exception.exceptions.NumberFormatException;
import xyz.pangosoft.ispendpoints.service.impl.UsuarioServiceImpl;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @ExceptionHandler({NotFoundException.class, NoSuchElementException.class})
    public ResponseEntity<?> notFoundException(Exception e){
        LOGGER.error("Error => Detalle: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler({DataAccessException.class, BadRequestException.class, SQLException.class})
    public ResponseEntity<?> dataAccessException(Exception e) {
        LOGGER.error("Error => Detalle: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
    }

    @ExceptionHandler({NumberFormatException.class})
    public ResponseEntity<?> formatException(Exception e) {
        LOGGER.error("Error => Detalle: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getCause().getMessage());
    }

}
