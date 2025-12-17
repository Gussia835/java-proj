package com.example.bankcards.controller;

import com.example.bankcards.dto.CardDto;
import com.example.bankcards.dto.CardRequest;
import com.example.bankcards.service.CardService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cards")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/create")
    public CardDto createCard(@RequestBody CardRequest request) {
        return this.cardService.create(request);
    }

}
