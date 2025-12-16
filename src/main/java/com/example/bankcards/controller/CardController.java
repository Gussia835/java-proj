package com.example.bankcards.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {

    @GetMapping
    public String getAll() {
        return "GET /cards - список карт";
    }

    @PostMapping
    public String create() {
        return "POST /cards - создание карты";
    }

    @GetMapping("/test")
    public String test() {
        return "GET /cards/test test";
    }
}
