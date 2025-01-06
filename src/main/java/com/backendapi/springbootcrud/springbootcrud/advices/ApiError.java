package com.backendapi.springbootcrud.springbootcrud.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiError {

    private HttpStatus status;
    private String errorMessage;
}
