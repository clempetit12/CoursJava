package com.example.demouploadsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoUploadSessionApplication {



        private String location="upload-dir";

    public static void main(String[] args) {
        
        SpringApplication.run(DemoUploadSessionApplication.class, args);

    }




}
