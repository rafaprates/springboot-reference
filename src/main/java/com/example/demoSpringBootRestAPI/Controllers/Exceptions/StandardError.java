package com.example.demoSpringBootRestAPI.Controllers.Exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;
    private Instant timestamp = Instant.now();
    private int status;
    private String error;
    private String message;
    private String path;

    public StandardError() {
    }
}
