package br.go.senac.ads4.exception;

import org.springframework.http.HttpStatus;

public class CustomErrorException extends RuntimeException {
    private HttpStatus status;
    private Object data;

    public CustomErrorException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public CustomErrorException(HttpStatus status, String message, Object data) {
        super(message);
        this.status = status;
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }
}
