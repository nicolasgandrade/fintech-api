package com.nicolasgandrade.fintech.service;

import com.nicolasgandrade.fintech.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
}
