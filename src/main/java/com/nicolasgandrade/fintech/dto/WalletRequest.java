package com.nicolasgandrade.fintech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletRequest {

    private UUID ownerId;
    private BigDecimal balance;
}
