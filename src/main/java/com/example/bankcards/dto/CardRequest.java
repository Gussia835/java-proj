package com.example.bankcards.dto;

import java.time.LocalDate;

public class CardRequest {
    private String cardNumber;
    private LocalDate validateDate;

    //==========================
    //      Геттеры сеттеры
    //==========================


    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public LocalDate getValidateDate() { return validateDate; }
    public void setValidateDate(LocalDate validateDate) { this.validateDate = validateDate; }


}
