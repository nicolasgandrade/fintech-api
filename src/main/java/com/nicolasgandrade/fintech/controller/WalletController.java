package com.nicolasgandrade.fintech.controller;

import com.nicolasgandrade.fintech.dto.WalletRequest;
import com.nicolasgandrade.fintech.model.Wallet;
import com.nicolasgandrade.fintech.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/wallets")
public class WalletController {

    private final WalletService walletService;

    @PostMapping
    public ResponseEntity<Wallet> createWallet(@RequestBody WalletRequest request) {
        return ResponseEntity.ok().body(walletService.createWallet(request));
    }

    public ResponseEntity<List<Wallet>> findAll() {
        return ResponseEntity.ok().body(walletService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wallet> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(walletService.findById(id));
    }
}
