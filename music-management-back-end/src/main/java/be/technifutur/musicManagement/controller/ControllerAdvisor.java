package be.technifutur.musicManagement.controller;

import be.technifutur.musicManagement.exception.ElementNotFoundException;
import be.technifutur.musicManagement.model.dto.ErrorDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleElementNotFound(ElementNotFoundException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDTO.builder()
                                .message(e.getMessage())
                                .method(HttpMethod.resolve(request.getMethod()))
                                .status(404)
                                .uri(request.getRequestURI())
                                .build()
                );
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleUserNotFound(UsernameNotFoundException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDTO.builder()
                                .message(e.getMessage())
                                .method(HttpMethod.resolve(request.getMethod()))
                                .status(404)
                                .uri(request.getRequestURI())
                                .build()
                );
    }
}
