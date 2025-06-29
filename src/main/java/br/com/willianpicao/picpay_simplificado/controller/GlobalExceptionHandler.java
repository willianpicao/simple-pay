package br.com.willianpicao.picpay_simplificado.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.willianpicao.picpay_simplificado.exception.BadRequestException;
import br.com.willianpicao.picpay_simplificado.exception.TransferNotAllowedException;
import br.com.willianpicao.picpay_simplificado.exception.UserNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + ex.getMessage());
    }

    @ExceptionHandler(TransferNotAllowedException.class)
    public ResponseEntity<String> handleTransferNotAllowedException(TransferNotAllowedException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error: " + ex.getMessage());
    }

}