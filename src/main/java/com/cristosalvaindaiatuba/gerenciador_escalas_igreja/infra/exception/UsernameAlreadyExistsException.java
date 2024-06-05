package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.infra.exception;

public class UsernameAlreadyExistsException extends RuntimeException {

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
