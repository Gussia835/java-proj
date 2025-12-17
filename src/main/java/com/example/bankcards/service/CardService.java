package com.example.bankcards.service;

import com.example.bankcards.dto.CardDto;
import com.example.bankcards.dto.CardRequest;

import com.example.bankcards.entity.Card;
import com.example.bankcards.entity.CardStatus;
import com.example.bankcards.entity.User;

import com.example.bankcards.util.CardNumberEncryptor;
import com.example.bankcards.util.JwtUtil;

import com.example.bankcards.repository.UserRepository;
import com.example.bankcards.repository.CardRepository;

import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.time.LocalDate;


@Service
public class CardService {
    private CardRepository cardRepository;
    private UserRepository userRepository;
    private JwtUtil jwtUtil;
    private CardNumberEncryptor cardNumberEncryptor;

    public CardService(CardRepository cardRepository,
                       UserRepository userRepository,
                       JwtUtil jwtUtil,
                       CardNumberEncryptor cardNumberEncryptor) {
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.cardNumberEncryptor = cardNumberEncryptor;
    }

    public CardDto create(CardRequest request) {

        Card card = new Card();
        card.setEncryptedNumber(cardNumberEncryptor.encrypt(request.getCardNumber()));
        card.setValidateDate(request.getValidateDate());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        card.setUser(user);
        card.setStatus(CardStatus.ACTIVE);
        card.setBalance(BigDecimal.ZERO);

        Card saved = cardRepository.save(card);

        return toDto(saved);
    }

    private CardDto toDto(Card card) {

        String mask_number = masking(cardNumberEncryptor.decrypt(card.getEncryptedNumber()));

        CardDto cardDto = new CardDto();

        cardDto.setMaskedNumber(mask_number);
        cardDto.setId(card.getId());
        cardDto.setStatus(card.getStatus().name());
        cardDto.setValidateDate(card.getValidateDate());
        cardDto.setBalance(card.getBalance());

        return cardDto;
    }

    private String masking(String numberCard) {

        return "**** **** **** " + numberCard.substring(12);;
    }

}
