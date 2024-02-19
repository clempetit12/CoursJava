package com.example.demo_exception.controller;

import com.example.demo_exception.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// Declarer les exceptions et faire un restcontrolleradvice qui s'occupe de tout
//@RestControllerAdvice
@ControllerAdvice
public class ExceptionRestController {

    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleArithmeticException(ArithmeticException e) {
        return "Il y a un problème arithmétique (dans le rest controller advice)"+ e.getMessage();

    }

    //pas besoin de renvoyer vers une page web
    @ResponseBody
    @ExceptionHandler(CustomException.class)
    //Bonne pratique response entity
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String customExceptionHandler(CustomException e) {
        return "Il y un problème de custom (dans le rest controller advice)" + e.getMessage();

    }

}
