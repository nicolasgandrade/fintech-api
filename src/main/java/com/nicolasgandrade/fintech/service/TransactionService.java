package com.nicolasgandrade.fintech.service;

import com.nicolasgandrade.fintech.dto.TransactionRequest;
import com.nicolasgandrade.fintech.exception.ResourceNotFoundException;
import com.nicolasgandrade.fintech.model.Transaction;
import com.nicolasgandrade.fintech.model.User;
import com.nicolasgandrade.fintech.model.Wallet;
import com.nicolasgandrade.fintech.repository.TransactionRepository;
import com.nicolasgandrade.fintech.repository.UserRepository;
import com.nicolasgandrade.fintech.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final WalletService walletService;

    @Transactional
    public void makeTransaction(TransactionRequest request) {
        //I'm searching for a user for while because will implement auth after to get the current user
        User payer = userService.findById(request.getPayerId());

        Wallet payerWallet = payer.getWallet();
        Wallet payeeWallet = walletService.findById(request.getPayeeWalletId());

        if (validateCredit(payerWallet, request.getAmount())) {
            transferMoney(payerWallet, payeeWallet, request.getAmount());
            Transaction transaction = Transaction.builder()
                    .amount(request.getAmount())
                    .payerWallet(payerWallet)
                    .payeeWallet(payeeWallet)
                    .build();
            transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("The payer doesn't have sufficient money to transfer");
        }

    }

    @Transactional
    public void transferMoney(Wallet payer, Wallet payee, BigDecimal amount) {
        payer.setBalance(payer.getBalance().subtract(amount));
        payee.setBalance(payee.getBalance().add(amount));
    }

    public boolean validateCredit(Wallet payer, BigDecimal amount) {
        if (payer.getBalance().compareTo(amount) >= 0) return true;
        return false;
    }
}
