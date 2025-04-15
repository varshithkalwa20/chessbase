package com.chess.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api")
    public class HomeController {

        @GetMapping("/home")
        public ResponseEntity<String> home() {
            return ResponseEntity.ok("Welcome to Chess Home!");
        }
    }


