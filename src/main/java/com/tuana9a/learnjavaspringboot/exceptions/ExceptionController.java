package com.tuana9a.learnjavaspringboot.exceptions;

import com.tuana9a.learnjavaspringboot.dto.JsonResponse;
import com.tuana9a.learnjavaspringboot.utils.JsonResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @Autowired
    private JsonResponseUtils responseUtils;

    @ExceptionHandler
    public ResponseEntity<JsonResponse> exception(Exception e) {
        e.printStackTrace();
        return responseUtils.internalServerError(e);
    }
}
