package com.example.demo_exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
//@ResponseBody
// Les deux combinés c'est un restcontroller
public class DemoController {

    @GetMapping("/salut")
    public String handleError(Model model) {
        Integer error = 25/0;
        return "salut";

    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleArithmeticException( ArithmeticException e, Model model) {
        model.addAttribute("errorMessage",e.getMessage());
        return "error";

    }
}
