package com.acmeflix.transfer;

import lombok.Value;

@Value
public class ApiError {
    Integer status;
    String message;
    String path;
}