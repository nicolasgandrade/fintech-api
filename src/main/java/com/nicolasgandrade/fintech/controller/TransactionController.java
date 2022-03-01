package com.nicolasgandrade.fintech.controller;

import com.nicolasgandrade.fintech.dto.TransactionRequest;
import com.nicolasgandrade.fintech.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> makeTransaction(@RequestBody TransactionRequest request) {
        transactionService.makeTransaction(request);
        return ResponseEntity.noContent().build();
    }
}
