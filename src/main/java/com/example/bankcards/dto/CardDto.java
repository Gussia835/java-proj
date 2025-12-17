package com.example.bankcards.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CardDto {
    private Long id;

    private String maskedNumber;

    private LocalDate validateDate;

    private String status;

    private BigDecimal balance;

    //==========================
    //      Геттеры сеттеры
    //==========================
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMaskedNumber() { return maskedNumber; }
    public void setMaskedNumber(String maskedNumber) { this.maskedNumber = maskedNumber; }

    public LocalDate getValidateDate() { return validateDate; }
    public void setValidateDate(LocalDate validateDate) { this.validateDate = validateDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
}
