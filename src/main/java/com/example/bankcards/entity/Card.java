package com.example.bankcards.entity;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "encryptedNumber", nullable = false, unique = true)
    private String encryptedNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "validityPeriod", nullable = false)
    private LocalDate validateDate;

    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @Column(name = "balance", precision = 19, scale = 2, nullable = false)
    private BigDecimal balance;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEncryptedNumber() { return encryptedNumber; }
    public void setEncryptedNumber(String encryptedNumber) { this.encryptedNumber = encryptedNumber; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public LocalDate getValidateDate() { return validateDate; }
    public void setValidateDate(LocalDate validateDate) { this.validateDate = validateDate; }

    public CardStatus getStatus() { return status; }
    public void setStatus(CardStatus status) { this.status = status; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

}
