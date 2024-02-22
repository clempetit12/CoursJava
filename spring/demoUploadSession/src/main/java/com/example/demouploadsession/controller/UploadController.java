package com.example.demouploadsession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @GetMapping("/form")
    public String showForm(){
        return "uploadForm";
    }

    @PostMapping("/ submitForm")
    public void submitForm(@RequestParam("image")MultipartFile image){
        Path destinationFile = Pat
    }
}
