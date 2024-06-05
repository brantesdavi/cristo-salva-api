package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.infra.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}