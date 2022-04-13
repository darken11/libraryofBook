package com.mgx.bookshandler.web.controller;

import com.mgx.bookshandler.constants.ApiConstants;
import com.mgx.bookshandler.web.customException.ApiErrorResponse;
import com.mgx.bookshandler.web.customException.BookNotFoundException;
import com.mgx.bookshandler.web.customException.CollectionBooksAlreadyExistException;
import com.mgx.bookshandler.web.customException.CollectionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleApiException(
            BookNotFoundException ex) {
        ApiErrorResponse response =
                new ApiErrorResponse(ApiConstants.error1,
                        ApiConstants.bookNotFoundWithCurrentId + ex.getId());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CollectionNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleApiException(
            CollectionNotFoundException ex) {
        ApiErrorResponse response =
                new ApiErrorResponse(ApiConstants.error1,
                        ApiConstants.collectionNotFoundWithCurrentId + ex.getId());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CollectionBooksAlreadyExistException.class)
    public ResponseEntity<ApiErrorResponse> handleApiException(
            CollectionBooksAlreadyExistException ex) {
        ApiErrorResponse response =
                new ApiErrorResponse(ApiConstants.error2,
                        ApiConstants.collectionAlreadyExist + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
