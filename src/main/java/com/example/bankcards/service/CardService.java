package com.example.bankcards.service;

import org.springframework.stereotype.Service;

@Service
public class CardService {


    public void CardService() {
        System.out.println("CardService Успешно загружен в Spring");
    }

    public String getText() {
        return "Все работает!";
    }

}
