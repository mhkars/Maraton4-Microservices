package com.halit.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    STOCK_NOT_CREATED(200,"Stock oluşturulamadı", INTERNAL_SERVER_ERROR),

    STATUS_NOT_FOUND(200,"Statu bilgisi gecersizdir", INTERNAL_SERVER_ERROR),
    STOCK_NOT_FOUND(201,"STOCK BULUNAMADI", INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    HttpStatus httpStatus;

}
