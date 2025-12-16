package com.example.bankcards.entity;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "encryptedNumber", nullable = false)
    private String encryptedNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User owner;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardStatus status;


    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEncryptedNumber() { return encryptedNumber; }
    public void setEncryptedNumber(String encryptedNumber) { this.encryptedNumber = encryptedNumber; }

    public User getUser() { return owner; }
    public void setUser(User user) { this.owner = user; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public CardStatus getStatus() { return status; }
    public void setStatus(CardStatus status) { this.status = status; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

}
