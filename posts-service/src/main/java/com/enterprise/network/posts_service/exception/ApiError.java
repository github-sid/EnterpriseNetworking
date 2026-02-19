package com.enterprise.network.posts_service.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {

    private LocalDateTime timestamp;
    private String error;
    private HttpStatus statusCode;

    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }

     public ApiError(String error, HttpStatus statusCode) {
        this.error = error;
        this.statusCode = statusCode;
    }

}
