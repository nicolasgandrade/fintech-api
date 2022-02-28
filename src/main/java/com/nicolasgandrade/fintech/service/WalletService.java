package com.nicolasgandrade.fintech.service;

import com.nicolasgandrade.fintech.dto.WalletRequest;
import com.nicolasgandrade.fintech.model.User;
import com.nicolasgandrade.fintech.model.Wallet;
import com.nicolasgandrade.fintech.repository.UserRepository;
import com.nicolasgandrade.fintech.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;
    private final UserRepository userRepository;

    public Wallet createWallet(WalletRequest request) {
        User owner = userRepository.findById(request.getOwnerId())
                .orElseThrow(() -> new RuntimeException("The given id does not return any user."));

        if (ownerHasWallet(owner)) throw new RuntimeException("The user already have a wallet");

        Wallet wallet = Wallet.builder()
                .owner(owner)
                .balance(request.getBalance())
                .build();

        walletRepository.save(wallet);
        owner.setWallet(wallet);
        userRepository.save(owner);

        return wallet;
    }

    public boolean ownerHasWallet(User owner) {
        return owner.getWallet() != null ? true : false;
    }
}
